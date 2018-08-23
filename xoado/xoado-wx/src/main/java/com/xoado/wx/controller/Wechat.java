package com.xoado.wx.controller;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSON;
import com.xoado.client.http.XoadoHttpRemote;
import com.xoado.common.XoadoResult;
import com.xoado.wx.bean.TblComponentverifyticket;
import com.xoado.wx.common.WXBizMsgCrypt;
import com.xoado.wx.service.IPackage;
import com.xoado.wx.wxbean.Button;
import com.xoado.wx.wxbean.CommonButton;
import com.xoado.wx.wxbean.ComplexButton;
import com.xoado.wx.wxbean.Menu;
import com.xoado.wx.wxbean.ViewButton;
import com.xoado.wx.wxbean.WeixinU;
import com.xoado.wx.wxbean.WxUser;

import net.sf.json.JSONObject;

/**
* @author 作者
* @version 创建时间：2018年6月11日 上午10:05:57
* 类说明
*/
@Controller
@RequestMapping("/wechatweixin")
public class Wechat {
	
	@Autowired
	private IPackage iPackage;

	
	private static XoadoHttpRemote xhr;
	
	private static final Logger logger = Logger.getLogger(Wechat.class);
	private static final String AppId = "wxc176ccd385b5465d";
	private static final String  AppSecret ="54665aef407f84a09049d0d8f3ef725d";
	private static String url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
	 private static String token = "xoadoToken";
	private static final String encodingAesKey ="1234567891234567891234567891234567891234567";
	
	

//	公众号-第三方平台
	/**
	 * 推送component_verify_ticket协议
	 * @param timestamp
	 * @param nonce
	 * @param encrypt_type
	 * @param msg_signature
	 * @param postData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	@ResponseBody
	public String getComponentVerifyTicket (
			@RequestParam("timestamp") String timestamp, //时间戳
			@RequestParam("nonce") String nonce,  //随机数
			@RequestParam("encrypt_type") String encrypt_type,
			@RequestParam("msg_signature") String msg_signature,
			@RequestBody String postData, //密文
			HttpServletRequest request) throws Exception{

			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, AppId);
			String mingwen = pc.encryptMsg(postData, timestamp, nonce);
			System.out.println("加密后: " + mingwen);
			postData = postData.replace("<AppId>", "<ToUserName>");
			postData = postData.replace("</AppId>", "</ToUserName>");
			// 第三方收到公众号平台发送的消息
			String result2 = pc.decryptMsg(msg_signature, timestamp, nonce, postData);
			System.out.println("解密后明文: " + result2);
			 Map<String, String> data = new HashMap<String, String>();			
			try {
				 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				 DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				 InputStream stream = new ByteArrayInputStream(result2.getBytes("UTF-8"));
				 Document doc = documentBuilder.parse(stream);
				 doc.getDocumentElement().normalize();
				 NodeList nodeList = doc.getDocumentElement().getChildNodes();
				 for (int idx = 0; idx < nodeList.getLength(); ++idx) {
					 Node node = nodeList.item(idx);
					 if (node.getNodeType() == Node.ELEMENT_NODE) {
						 Element element = (Element) node;
						 data.put(element.getNodeName(), element.getTextContent());
					 }
				 }
				 
			} catch (Exception e) {
				logger.info(e);
			}
			 String componentverifyticket = data.get("ComponentVerifyTicket");
			 System.out.println("获取票据"+componentverifyticket);
			 String AppId = data.get("AppId");
			 iPackage.TblComponentverifyticketadd(AppId, componentverifyticket);

	
		return "success"; 
	}
	
	/**
	 * 
	 * @param WX3_app_id 第三方平台方appid
	 * @param request
	 * @return				获取第三方平台component_access_token
	 * 						根据第三方平台AppId获取到数据库的票据，携带票据、密钥、第三方平台AppId，到微信服务器获取component_access_token
	 * 						带着component_access_token、appid、去微信服务器获取pre_auth_code
	 * @throws Exception
	 */
	@RequestMapping("token")
	@ResponseBody
	 public  Map<String, Object> getComponentAccessToken(String WX3_app_id,HttpServletRequest request) throws Exception{
//		从数据库获取票据
		 TblComponentverifyticket ticket = iPackage.selectComponentVerifyTicket(WX3_app_id);
		 String componentverifyticket = ticket.getComponentverifyticket();
		 System.out.println("componentverifyticket:"+componentverifyticket);
//		 组装json
		 JSONObject json = new JSONObject();
		 json.put("component_appid", WX3_app_id);
		 json.put("component_appsecret", AppSecret);
		 json.put("component_verify_ticket", componentverifyticket);
		 String transJson = json.toString();
		 Map<String, Object> map = XoadoHttpRemote.Bodysend(url, transJson);
//		 map中返回的数据为：component_access_token，
		 
		 Object component_access_token = map.get("component_access_token");
		 System.out.println("获取component_access_token："+component_access_token);
//		 将获取到的component_access_token保存到全局
		 request.getSession().getServletContext().setAttribute("component_access_token", component_access_token);
//		获取预授权码pre_auth_code
		String code_url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token="+component_access_token;
		JSONObject code_json = new JSONObject();
		code_json.put("component_appid", WX3_app_id);
		String code_transJson = json.toString();
		Map<String, Object> code_map = XoadoHttpRemote.Bodysend(code_url, code_transJson);
		String pre_auth_code = (String)code_map.get("pre_auth_code");
		iPackage.TblComponentverifyticketupdate_code(WX3_app_id, pre_auth_code);
		return code_map;
		 
	 }
	

		/**
		 * 
		 * @param WX3_app_id  第三方平台AppId   网页授权
		 * @return  拉起授权页进行授权
		 */
	@RequestMapping("/MSGAPP")
	public ModelAndView  message_event(String WX3_app_id){
		TblComponentverifyticket tblComponentverifyticket = iPackage.selectComponentVerifyTicket(WX3_app_id);
//		授权后回调URI，得到授权码（authorization_code）和过期时间
		String code = tblComponentverifyticket.getPreAuthCode();
		String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?"
				+ "component_appid="+WX3_app_id
				+ "&pre_auth_code="+code
				+ "&redirect_uri=www.xoado.com/wx/weixin/getauthorization_code";		
		
		return new ModelAndView("redirect:"+url);
		
	}
	
//		授权后回调URI，得到授权码（authorization_code）和过期时间
	/**
	 * 
	 * @param auth_code   授权码，第一次获取是管理员授权携带过来的
	 * @param expires_in
	 * @param request
	 * @return
	 */
	@RequestMapping("/getauthorization_code")
	public String getauthorization_code(String auth_code,String expires_in,HttpServletRequest request){
		System.out.println("auth_code:"+auth_code);
//		将授权码auth_code保存到全局
		request.getSession().getServletContext().setAttribute("auth_code", auth_code);
//		获取数据库中保存的  接口调用凭据 component_access_token
		TblComponentverifyticket ticket = iPackage.selectComponentVerifyTicket(AppId);
		String accessToken = ticket.getComponentAccessToken();

		String url ="https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="+accessToken;
//		组装json数据
		 JSONObject json = new JSONObject();
		 json.put("component_appid", AppId);
		 json.put("authorization_code", auth_code);
		 String transJson = json.toString();
		 Map<String, Object> map = XoadoHttpRemote.Bodysend(url, transJson);
		 
//		 使用授权码换取公众号或小程序的接口调用凭据和授权信息：authorizer_access_token和authorizer_refresh_token
//		 授权信息
		 Object authorization_info = map.get("authorization_info");   
//		 授权方appid
		 Object authorizer_appid = map.get("authorizer_appid");			
//		 授权方接口调用凭据（在授权的公众号或小程序具备API权限时，才有此返回值），也简称为令牌
		 Object authorizer_access_token = map.get("authorizer_access_token");
		 System.out.println("authorizer_access_token:"+authorizer_access_token);
		 request.getSession().setAttribute("authorizer_access_token", authorizer_access_token);
//		 有效期
		 Object expires_in2 = map.get("expires_in");
//		 接口调用凭据刷新令牌  并将参数保存到数据库 避免丢失
		 Object authorizer_refresh_token = map.get("authorizer_refresh_token");
		 System.out.println("authorizer_refresh_token:"+authorizer_refresh_token);
		 iPackage.TblComponentverifyticketupdate_token(AppId, (String)authorizer_refresh_token);
//		 授权给开发者的权限集列表
		 Object func_info = map.get("authorizer_appid");
		 
		return "show";
	}
//		获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
	@RequestMapping("/updatetoken")
	public Object update(HttpServletRequest request){
//		获取全局component_access_token
		String component_access_token = (String)request.getSession().getServletContext().getAttribute("component_access_token");
		String url = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token="+component_access_token;
//		获取调用刷新凭据authorizer_refresh_token
		TblComponentverifyticket ticket = iPackage.selectComponentVerifyTicket(AppId);
		String authorizer_refresh_token = ticket.getComponentAccessToken();
//		组装参数
		JSONObject json = new JSONObject();
		json.put("component_appid", AppId);
		json.put("authorizer_appid", "wxb0eb37d7c68f0c0d");  //授权方的appid
		json.put("authorizer_refresh_token", authorizer_refresh_token);
		String string = json.toString();
//		发送请求
		Map<String, Object> map = XoadoHttpRemote.Bodysend(url, string);
//		授权方令牌
		Object authorizer_access_token = map.get("authorizer_access_token");
		request.getSession().getServletContext().setAttribute("authorizer_access_token", authorizer_access_token);
		System.out.println("authorizer_access_token:"+authorizer_access_token);
//		有效期，为2小时
		Object expires_in = map.get("expires_in");
//		刷新令牌
		Object authorizer_refresh_token2 = map.get("authorizer_refresh_token");
		System.out.println("authorizer_refresh_token:"+authorizer_refresh_token2);
		return authorizer_refresh_token2;	
	}
	

	
	
	
	 /**
	  * 调取微信内授权
	  */
	@RequestMapping("/reqcode")
	public ModelAndView getappuser(){
																																	
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb0eb37d7c68f0c0d"
				+ "&redirect_uri=www.xoado.com/wx/weixin/getcode?code=CODE&state=STATE&appid=APPID"
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=state"
				+ "&component_appid=wxc176ccd385b5465d";
		System.out.println("url:"+url);
		return new ModelAndView("redirect:"+url);
	}
	
	@RequestMapping("/getcode")
	public String getcode(@RequestParam("code") String code,@RequestParam("state") String state,@RequestParam("appid") String appid,HttpServletRequest request){
		
		/**
		 * 通过code换取access_token
		 * appid 公众号的appid
		 * code  写第一步获取的code参数
		 * grant_type  填authorization_code
		 * component_appid  服务开发方的appid
		 * component_access_token    服务开发方的access_token
		 * 
		 */
		
		System.out.println("-code-"+code);
		System.out.println("-state-"+state);
		System.out.println("appid--"+appid);
		
		String substring = code.substring(1, code.length());
		String substring2 = substring.substring(1, substring.length());
		String substring3 = substring2.substring(1, substring2.length());
		String substring4 = substring3.substring(1, substring3.length());
		String substring5 = substring4.substring(1, substring4.length());
		System.out.println("substring5"+substring5);

//		这个token是component_access_token
		String component_access_token = (String)request.getSession().getServletContext().getAttribute("component_access_token");
		String url = "https://api.weixin.qq.com/sns/oauth2/component/access_token?"
				+ "appid="+appid
				+ "&code="+substring5
				+ "&grant_type=authorization_code"
				+ "&component_appid="+AppId
				+ "&component_access_token="+component_access_token;
		System.out.println("测试:"+url);
		xhr= new XoadoHttpRemote("get", url);
		String send = xhr.send();
		System.out.println("send:"+send);
		Map<String,Object> map = JSON.parseObject(send);
		Object openid = map.get("openid");

		request.getSession().getServletContext().setAttribute("Myopenid", openid);
		Object access_token = map.get("access_token");
		String urluser = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
		System.out.println("urluser:"+urluser);
		Object wxjson = Wechat.getuser(urluser);
		Map<String, Object> wxmap = JSON.parseObject((String)wxjson);
		ArrayList<WxUser> list = new ArrayList<>();
		
		WxUser user = new WxUser();
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
		return "wxuser";
		
	}
	
	public static Object getuser(String url){
		xhr= new XoadoHttpRemote("get", url);
		String send = xhr.send();
		return send;
	}
	
	/**
	 * 创建菜单
	 * @throws UnsupportedEncodingException 
	 */
	
	@RequestMapping("/addmenu")
	@ResponseBody
	public XoadoResult MenuManager (HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String access_token =(String) request.getSession().getServletContext().getAttribute("authorizer_access_token");
		
		if(access_token!=null){
			Menu menu = getMenu();
			System.out.println("addmenu:"+menu);
			String string = menu.toString();
			System.out.println("string:"+string);
//			Object createMenu =WeixinUtil.createMenu(getMenu(), access_token);
			int result  = WeixinU.createMenu(menu, access_token);
			
			
			if (0 == result) {
				
				logger.info("菜单创建成功！");
				
			}
			logger.info("菜单创建失败，错误码：" + result);   
			
			/**
			if(createMenu!=null){
				System.out.println("菜单创建成功");
				logger.info("菜单创建成功！");
				return XoadoResult.build(200, "123","菜单创建成功");
			}else {
				System.out.println("菜单创建失败");
				logger.info("菜单创建失败！");
			}
		}
		*/
		}
		return null;	
		
	}
	 private static Menu getMenu() {  
//		 CommonButton btn11 = new CommonButton();  
		 ViewButton btn11 = new ViewButton();
	        btn11.setName("查询账单");  
	        btn11.setType("view");  
	        btn11.setKey("11"); 
	        btn11.setUrl("http://www.baidu.com");
	  
	        CommonButton btn12 = new CommonButton(); 
	        btn12.setName("查看物流");  
	        btn12.setType("click");  
	        btn12.setKey("12"); 
	      
	  
	        ViewButton btn13 = new ViewButton();  
	        btn13.setName("周边搜索");  
	        btn13.setType("click");  
	        btn13.setKey("13"); 
	        btn13.setUrl("http://www.baidu.com");
	  
	        ViewButton btn14 = new ViewButton(); 
	        btn14.setName("扫一扫");  
	        btn14.setType("click");  
	        btn14.setKey("14");
	        btn14.setUrl("http://www.baidu.com");
	  
	        CommonButton btn21 = new CommonButton();  
	        btn21.setName("点歌");  
	        btn21.setType("click");  
	        btn21.setKey("21");  
	  
	        CommonButton btn22 = new CommonButton();  
	        btn22.setName("快递服务");  
	        btn22.setType("click");  
	        btn22.setKey("22");  
	  
	        CommonButton btn23 = new CommonButton();  
	        btn23.setName("电台");  
	        btn23.setType("click");  
	        btn23.setKey("23");  
	  
	        CommonButton btn24 = new CommonButton();  
	        btn24.setName("人脸识别");  
	        btn24.setType("click");  
	        btn24.setKey("24");  
	  
	        CommonButton btn25 = new CommonButton();  
	        btn25.setName("聊天唠嗑");  
	        btn25.setType("click");  
	        btn25.setKey("25");  
	  
	        
	        CommonButton btn31 = new CommonButton();  
	        btn31.setName("我的朋友圈");  
	        btn31.setType("click");  
	        btn31.setKey("31");  
	  
	        CommonButton btn32 = new CommonButton();  
	        btn32.setName("电影");  
	        btn32.setType("click");  
	        btn32.setKey("32");  
	  
	        CommonButton btn33 = new CommonButton();  
	        btn33.setName("联系客服");  
	        btn33.setType("click");  
	        btn33.setKey("33");  
	  
	        ComplexButton mainBtn1 = new ComplexButton();  
	        mainBtn1.setName("生活助手");  
	        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14 });  
	  
	        ComplexButton mainBtn2 = new ComplexButton();  
	        
	        mainBtn2.setName("休闲驿站");  
	        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });  
	  
	        ComplexButton mainBtn3 = new ComplexButton();  
	        mainBtn3.setName("更多体验");  
	        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });  
	  		
	       
	        Menu menu = new Menu();  
	        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
	  
	        return menu;  
	 }
	 /**
	  * 
	  * @param request
	  * @return  该接口是获取微信公众号的access_token而非第三方的access_token
	  */
	 @RequestMapping("/appid_access_token")
	 @ResponseBody
	 public XoadoResult getaccess_token(HttpServletRequest request){
		 String appid = "wxb0eb37d7c68f0c0d";
		 String appsecret = "2bdb38d1d134534232597d6c3577f9b5";
		 String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
		 xhr= new XoadoHttpRemote("get", url);
		 String appid_access_token = xhr.send();
		 Map<String,Object> map = JSON.parseObject(appid_access_token);
		 String access_token = (String)map.get("access_token");
		 System.out.println("token:"+access_token);
		 request.getSession().getServletContext().setAttribute("appid_access_token", access_token);
		return XoadoResult.build(200, "公众号的access_token",appid_access_token);
		 
	 }
}
