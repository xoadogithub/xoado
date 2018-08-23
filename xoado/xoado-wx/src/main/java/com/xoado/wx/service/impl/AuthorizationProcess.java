package com.xoado.wx.service.impl;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xoado.client.http.XoadoHttpRemote;
import com.xoado.wx.bean.TblComponentverifyticket;
import com.xoado.wx.common.WXBizMsgCrypt;
import com.xoado.wx.common.XmlParsing;
import com.xoado.wx.mapper.TblComponentverifyticketMapper;
import com.xoado.wx.service.IAuthorizationProcess;
import com.xoado.wx.wxbean.WxUser;

import net.sf.json.JSONObject;

/**
* @author 作者
* @version 创建时间：2018年6月26日 上午10:08:47
* 类说明
*/
@Service
public class AuthorizationProcess implements IAuthorizationProcess{

//	private static final Logger logger = Logger.getLogger(AuthorizationProcess.class);
	private static final String AppId = "wxc176ccd385b5465d";
	private static final String  AppSecret ="54665aef407f84a09049d0d8f3ef725d";
	private static String access_token_url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
	private static String pre_auth_code_url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";
	private static String authorizer_access_token_url ="https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";
	private static String token = "xoadoToken";
	private static final String encodingAesKey ="1234567891234567891234567891234567891234567";
	private static XoadoHttpRemote xhr;
	
	@Autowired
	private TblComponentverifyticketMapper tblComponentverifyticketMapper;
	/**
	 * 第一步：获取票据
	 */
	@Override
	public String GetComponent_verify_ticket(String postData, String timestamp, String nonce,String msg_signature,
			HttpServletRequest request) throws Exception {	
		
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, AppId);	
//		String mingwen = pc.encryptMsg(postData, timestamp, nonce);
//		替换AppId
		postData = postData.replace("<AppId>", "<ToUserName>");
		postData = postData.replace("</AppId>", "</ToUserName>");
//		解密后的明文result2   xml格式
		String result2 = pc.decryptMsg(msg_signature, timestamp, nonce, postData);
//		xml解析
		Map<String, String> map = XmlParsing.ToXml(result2);	
//		map中可以获取到：AppId：第三方平台appid，CreateTime：时间戳，InfoType：component_verify_ticket，ComponentVerifyTicket：Ticket内容
		String ComponentVerifyTicket = map.get("ComponentVerifyTicket");
		
		String WX3_app_id = map.get("AppId");
		TblComponentverifyticket key = tblComponentverifyticketMapper.selectByPrimaryKey(WX3_app_id);
		if(key!=null){
		key.setComponentverifyticket(ComponentVerifyTicket);
		tblComponentverifyticketMapper.updateByPrimaryKey(key);
		
		}else{
		System.out.println("key等于null");
		key.setWx3AppId(WX3_app_id);
		key.setComponentverifyticket(ComponentVerifyTicket);
		key.setPreAuthCode(null);
		key.setComponentAccessToken(null);
		tblComponentverifyticketMapper.insert(key);
		}	
		
		
//		将获取到的票据保存到全局
		request.getSession().getServletContext().setAttribute("ComponentVerifyTicket", ComponentVerifyTicket);	
		return "success";
	}


	/**
	 * 第二步，获取第三方平台component_access_token,
	 * 第三步：根据component_access_token获取预授权码pre_auth_code
	 */
	@Override
	public  Map<String, Object> GetComponent_access_token(String WX3_app_id, HttpServletRequest request) throws Exception {
//		获取全局票据
//		String ComponentVerifyTicket =(String) request.getSession().getServletContext().getAttribute("ComponentVerifyTicket");

			TblComponentverifyticket key = tblComponentverifyticketMapper.selectByPrimaryKey(WX3_app_id);
			String ComponentVerifyTicket = key.getComponentverifyticket();
		
//		组装json
		JSONObject json = new JSONObject();
		json.put("component_appid", WX3_app_id);
		json.put("component_appsecret", AppSecret);
		json.put("component_verify_ticket", ComponentVerifyTicket);
		String transJson = json.toString();
//		返回的map中包含component_access_token（第三方平台access_token）,expires_in（有效期）
		Map<String, Object> Component_access_token_map = XoadoHttpRemote.Bodysend(access_token_url, transJson);
//		获取Component_access_token
		String component_access_token = (String)Component_access_token_map.get("component_access_token");
		/**
		 * 暂时将component_access_token存到全局
		 */
		request.getSession().getServletContext().setAttribute("component_access_token", component_access_token);
//		组装获取预授权码的json
		JSONObject code_json = new JSONObject();
		code_json.put("component_appid", WX3_app_id);
		String code_transJson = json.toString();
//		返回预授权码pre_auth_code，有效期 expires_in
		Map<String, Object> pre_auth_code_map = XoadoHttpRemote.Bodysend(pre_auth_code_url+component_access_token, code_transJson);
		String pre_auth_code = (String)pre_auth_code_map.get("pre_auth_code");
		/**
		 * 暂时将pre_auth_code存到全局
		 */
		request.getSession().getServletContext().setAttribute("pre_auth_code", pre_auth_code);
		
		return pre_auth_code_map;	
	}

//	拉起网页授权
	@Override
	public ModelAndView page_authorization(String WX3_app_id, HttpServletRequest request) {
		String pre_auth_code = (String)request.getSession().getServletContext().getAttribute("pre_auth_code");
		String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?"
					 + "component_appid="+WX3_app_id
					 + "&pre_auth_code="+pre_auth_code
					 + "&redirect_uri=www.xoado.com/wx/weixin/getauthorization_code";  //回调
		return new ModelAndView("redirect:"+url);
	}

	/**
	 * 获取授权码auth_code  利用授权码调用公众号或小程序的相关API
	 */
	@Override
	public void get_auth_code(String auth_code, String expires_in, HttpServletRequest request) {
		/**
		 * 暂时保存到全局
		 */
		request.getSession().getServletContext().setAttribute("auth_code", auth_code);
//		获取component_access_token
		String component_access_token = (String)request.getSession().getServletContext().getAttribute("component_access_token");
		JSONObject json = new JSONObject();
		json.put("component_appid", AppId);
		json.put("authorization_code", auth_code);
		String transJson = json.toString();
//		可以获取到授权信息（authorization_info），授权方appid（authorizer_appid），授权方接口调用凭据（authorizer_access_token），有效期（expires_in），接口调用凭据刷新令牌--重要（authorizer_refresh_token），权限集（func_info）
		Map<String, Object> map = XoadoHttpRemote.Bodysend(authorizer_access_token_url+component_access_token, transJson);
//		 授权信息
		Object authorization_info = map.get("authorization_info"); 
		System.out.println(authorization_info);
//		 授权方appid
		Object authorizer_appid = map.get("authorizer_appid");	
		System.out.println(authorizer_appid);
//		 授权方接口调用凭据（在授权的公众号或小程序具备API权限时，才有此返回值），也简称为令牌
		Object authorizer_access_token = map.get("authorizer_access_token");
		request.getSession().getServletContext().setAttribute("authorizer_access_token", authorizer_access_token);
//		 有效期
		Object expires_in2 = map.get("expires_in");
		System.out.println(expires_in2);
//		 接口调用凭据刷新令牌  并将参数保存到数据库 避免丢失
		Object authorizer_refresh_token = map.get("authorizer_refresh_token");
		System.out.println(authorizer_refresh_token);
//		 授权给开发者的权限集列表
		Object func_info = map.get("authorizer_appid");
		System.out.println(func_info);

	}
/**
 * 微信（用户）授权
 */
	@Override
	public ModelAndView user_authorization(HttpServletRequest request) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb0eb37d7c68f0c0d"
				+ "&redirect_uri=www.xoado.com/wx/weixin/getcode?code=CODE&state=STATE&appid=APPID"
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=state"
				+ "&component_appid=wxc176ccd385b5465d";
		return new ModelAndView("redirect:"+url);
	}


	@Override
	public void getCode(String code, String state, String appid, HttpServletRequest request) {
		
		System.out.println("-code-"+code);
		System.out.println("-state-"+state);
		System.out.println("appid--"+appid);
		String substring = code.substring(1, code.length());
		String substring2 = substring.substring(1, substring.length());
		String substring3 = substring2.substring(1, substring2.length());
		String substring4 = substring3.substring(1, substring3.length());
		String substring5 = substring4.substring(1, substring4.length());
		
		String component_access_token = (String)request.getSession().getServletContext().getAttribute("component_access_token");
		System.out.println("component_access_token:"+component_access_token);
//		获取第一步的code后，请求以下链接获取access_token：
		String url = "https://api.weixin.qq.com/sns/oauth2/component/access_token?"
				+ "appid="+appid
				+ "&code="+substring5
				+ "&grant_type=authorization_code"
				+ "&component_appid="+AppId
				+ "&component_access_token="+component_access_token;
		xhr= new XoadoHttpRemote("get", url);
		System.out.println("测试:"+url);
		String send = xhr.send();
		System.out.println("send:"+send);
		Map<String,Object> map = JSON.parseObject(send);
	
//		用户刷新access_token
		String refresh_token = (String)map.get("refresh_token");
		request.getSession().getServletContext().setAttribute("refresh_token", refresh_token);
		String scope = (String)map.get("scope");
		String access_token = (String)map.get("access_token");
		String openid = (String)map.get("openid");
		System.out.println("openId:"+openid);
		
		
		
		String urluser = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
		Object getuser = AuthorizationProcess.getuser(urluser);
		Map<String, Object> wxmap = JSON.parseObject((String)getuser);
		ArrayList<WxUser> list = new ArrayList<>();
		WxUser user = new WxUser();
		System.out.println("openid:"+map.get("openid"));
		user.setOpenid(wxmap.get("openid"));
		user.setNickname(wxmap.get("nickname"));
		user.setSex(wxmap.get("sex"));
		user.setProvince(wxmap.get("province"));
		user.setCity(wxmap.get("city"));
		user.setCountry(wxmap.get("country"));
		user.setHeadimgurl(wxmap.get("headimgurl"));
		user.setPrivilege(wxmap.get("privilege"));
		user.setUnionid(wxmap.get("unionid"));
		list.add(user);
		request.getSession().setAttribute("WXUSER", list);

	}

	public static Object getuser(String url) {
		xhr= new XoadoHttpRemote("get", url);
		String send = xhr.send();
		return send;
	}
//	用户刷新token
	public static Object updateAccess_token(HttpServletRequest request){
		
		String component_access_token =(String) request.getSession().getServletContext().getAttribute("component_access_token");
		String refresh_token =(String) request.getSession().getServletContext().getAttribute("refresh_token");
		
		String url = "https://api.weixin.qq.com/sns/oauth2/component/refresh_token?appid=wxc176ccd385b5465d&grant_type=refresh_token&component_appid="+AppId+"&component_access_token=&"+component_access_token+"refresh_token="+refresh_token;
		xhr= new XoadoHttpRemote("get", url);
		String send = xhr.send();
		Map<String,Object> map = JSON.parseObject(send);
		String access_token = (String)map.get("access_token");
		String expires_in = (String)map.get("expires_in");
		String refresh_token2 = (String)map.get("refresh_token");
		String openid = (String)map.get("openid");
		String scope = (String)map.get("scope");
		return access_token;
	}
	
	


	

}
