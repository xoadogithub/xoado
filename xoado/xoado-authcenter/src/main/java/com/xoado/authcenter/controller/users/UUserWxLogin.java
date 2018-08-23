package com.xoado.authcenter.controller.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xoado.authcenter.bean.TblUser;
import com.xoado.authcenter.bean.TblWeixinUser;
import com.xoado.authcenter.jedis.XoadoSession;
import com.xoado.authcenter.service.Iuser.IUserWxLogin;
import com.xoado.client.http.XoadoHttpRemote;
import com.xoado.cloud.frame.authcenter.access.UserInfoUtil;
import com.xoado.common.AES;
import com.xoado.common.HttpsUtil;
import com.xoado.common.JsonUtils;
import com.xoado.common.MD5;
import com.xoado.common.XoadoResult;
import com.xoado.protocol.AccessIdentity;
import com.xoado.protocol.OrganizationStauts;



@Controller
@RequestMapping("/access/wxlogin")
public class UUserWxLogin {
	
	@Autowired
	private XoadoSession xoadosession;
	@Autowired
	private IUserWxLogin wxlogin;
	
	private static XoadoHttpRemote xhr;
	
//	微信登录
	@RequestMapping(value="wxGetOpenId",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> GetOpenId(@RequestParam("code") String code,HttpServletRequest request){
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+UserInfoUtil.getAppid()+"&secret="+UserInfoUtil.getAppsecret()+"&js_code="+code+"&grant_type=authorization_code";
		xhr= new XoadoHttpRemote("get", url);
		String send = xhr.send();
		net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(send);
		String openId = (String)jsonObject.get("openid");
	
		
		 List<TblWeixinUser> list = wxlogin.WXuser_login_select(openId);
		 AccessIdentity identity = new AccessIdentity();
		 ArrayList<Object> xoadolist = new ArrayList<>();
		 String tokenid = MD5.MD5Encode(UUID.randomUUID().toString());
		 Map<String,Object> map = new HashMap<>();
		 
		if(list.size()==0){
			 TblWeixinUser user = new TblWeixinUser();
			 user.setOpenid(openId);
			 user.setXdappid("XDAPPID");
			 user.setWxappid(UserInfoUtil.getAppid());
			 user.setNickName(null);
			 user.setSex(null);
			 user.setCity(null);
			 user.setCountry(null);
			 user.setProvince(null);
			 user.setUserid(null);
			 user.setBindingTime(new Date());
			 user.setCreateTime(new Date());
			 wxlogin.register_Wxuser(user);
			 
			 	identity.setDate(new Date().getTime());
				
				identity.setTokenId(MD5.MD5Encode(UUID.randomUUID().toString()));
				
				identity.setUserId(null);
				
				identity.setUserName(null);
				
				identity.setUserType(OrganizationStauts.NORMAL.getDescribe());
				
				identity.setOpenId(openId);
				
				xoadolist.add(identity);
				
				String json = JsonUtils.objectToJson(xoadolist);
				
				System.out.println("微信表没有该用户:"+json);
				
				xoadosession.set(tokenid,json);
				
				xoadosession.expire(tokenid, 1800);
				
				map.put("tokenid", tokenid);
				
				return map;
		}
		for (TblWeixinUser tblWeixinUser : list) {
			
			identity.setDate(new Date().getTime());
			
			identity.setTokenId(MD5.MD5Encode(UUID.randomUUID().toString()));
			
			identity.setUserId(tblWeixinUser.getUserid());
			
			identity.setUserName(tblWeixinUser.getNickName());
			
			identity.setUserType(OrganizationStauts.NORMAL.getDescribe());
			
			identity.setOpenId(openId);
			
			xoadolist.add(identity);
			
			String json = JsonUtils.objectToJson(xoadolist);
			
			xoadosession.set(tokenid,json);
			
			xoadosession.expire(tokenid, 1800);
			
			map.put("tokenid", tokenid);
			map.put("openid", openId);
		}
			
			
		return map;	
		
	}

	@RequestMapping(value="wxlogin",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> wx_login(String appId,@RequestParam("code") String code,@RequestParam("iv") String iv,@RequestParam("encryptedData") String encryptedData,@RequestParam("xdappid") String xdappid,HttpServletRequest request,HttpServletResponse response){
		System.out.println("wxlogin:"+code);
		Map<String,Object> map = new HashMap<>();
		
		if(code!=null || code.equals("")){
			
			String CODE = code;
			
			String session_key="";
			
			String openId = "";
			
			String token =UserInfoUtil.getWebAccess(CODE);
			
			String xoado_response = HttpsUtil.httpsRequestToString(token, "GET", null);
			
			JSONObject jsonObject = JSON.parseObject(xoado_response);
			
			session_key = jsonObject.getString("session_key");
			
			try {
				
				String result = AES.decrypt(encryptedData, session_key, iv, "UTF-8");
				
				if(null != result && result.length() > 0){
//					生成一个tokenId
					String tokenid = MD5.MD5Encode(UUID.randomUUID().toString());
					
					JSONObject userInfoJSON = JSON.parseObject(result);
					
					 openId =(String) userInfoJSON.get("openId");//获取openid
					 
					 String nickname = (String)userInfoJSON.get("nickName");
					 
					 String city = (String)userInfoJSON.get("city");
					 
					 String country = (String)userInfoJSON.get("country");
					 
					 String province = (String)userInfoJSON.get("province");
					 
					 if(null !=userInfoJSON && openId!=null){
						 
						 List<TblWeixinUser> list = wxlogin.WXuser_login_select(openId);
						 
						 List<AccessIdentity> xoadolist = new ArrayList<AccessIdentity>();
						 
						 AccessIdentity identity = new AccessIdentity();
						 
						 if(list==null || list.size()==0){
							 
							 TblWeixinUser user = new TblWeixinUser();
							 
							 user.setOpenid(openId);
							 user.setXdappid(xdappid);
							 user.setWxappid(appId);
							 user.setNickName(nickname);
							 user.setSex(null);
							 user.setCity(city);
							 user.setCountry(country);
							 user.setProvince(province);
							 user.setUserid(null);
							 user.setBindingTime(new Date());
							 user.setCreateTime(new Date());
							 wxlogin.register_Wxuser(user);
//							添加完成后生成token并保存
							 
								 
								 	identity.setDate(new Date().getTime());
									
									identity.setTokenId(MD5.MD5Encode(UUID.randomUUID().toString()));
									
									identity.setUserId(null);
									
									identity.setUserName(nickname);
									
									identity.setUserType(OrganizationStauts.NORMAL.getDescribe());
									
									identity.setOpenId(openId);
									
									xoadolist.add(identity);
									
									String json = JsonUtils.objectToJson(xoadolist);
									
									System.out.println("微信表没有该用户:"+json);
									
									xoadosession.set(tokenid,json);
									
									xoadosession.expire(tokenid, 1800);
							
							 return map; 
						 }else {

							 for (TblWeixinUser tblwxUser : list) {
									
									identity.setDate(new Date().getTime());
									
									identity.setTokenId(MD5.MD5Encode(UUID.randomUUID().toString()));
									
									identity.setUserId(tblwxUser.getUserid());
									
									identity.setUserName(tblwxUser.getNickName());
									
									identity.setUserType(OrganizationStauts.NORMAL.getDescribe());
									
									identity.setOpenId(tblwxUser.getOpenid());
									
									xoadolist.add(identity);
									
									String json = JsonUtils.objectToJson(xoadolist);
									
									System.out.println("微信表有该用户:"+json);
									
									xoadosession.set(tokenid,json);
									
									xoadosession.expire(tokenid, 1800);
									
								}
	
							map.put("tokenid", tokenid); 
								
							map.put("status", 0);
								
							map.put("msg", "解密成功"); 
						 }
						 
					 }
//					 Map<String, Object> userInfo = new HashMap<String, Object>();
					 
//					 userInfo.put("openId", userInfoJSON.get("openId"));
					 
//					 map.put("userInfo", userInfo);
					 
					 return map;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			 map.put("status", 0);  
			 map.put("msg", "解密失败");
		}
		
		return map;
		
	}
	@RequestMapping(value="{appId}",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult bindingphone(@PathVariable("appId") String appId,String PhoneMember,String code,HttpServletRequest request){
//	接收手机验证码进行对比
//	数据库查询2张表
//	无手机号，无appId进行添加
//	获取userid
//	绑定userid	
	
		return null;
		
	}
	/**
	 * 微信用户绑定手机
	 * @param openId
	 * @param phoneNumber
	 * @param Verification_code
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register_phone",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult Wx_register_phone(String openId,String phoneNumber,String Verification_code,HttpServletRequest request){
		XoadoResult result = wxlogin.Wx_register_phone(openId, phoneNumber, Verification_code, request);
		return result;
	}

	
}
