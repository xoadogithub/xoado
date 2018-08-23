package com.xoado.organize.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xoado.common.XoadoResult;
import com.xoado.organize.service.IUser;

/**
 * 
 * @author 80665
 *
 */

@Controller
@RequestMapping("/users")
public class UUser {
	
	@Autowired
	private IUser iUser;
		/**
		 * 
		 * @param page  页数
		 * @param rows	每页显示
		 * @param request  发送request请求
		 * @return 1.	[get]/oauth/users  			返回用户列表?orgid=&name=&status=
		 */
		@RequestMapping(value="",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult all_search(@RequestParam ("page") int page,@RequestParam("rows") int rows,HttpServletRequest request){
			return iUser.all_search(page,rows,request);	
		}
		/**
		 * 
		 * @param request  header中保存tokenid
		 * @return   [get]/oauth/users/me       返回当前用户详情
		 */
		@RequestMapping(value="me",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult active_user(HttpServletRequest request){
			return iUser.active_user(request);
		}
		/**
		 * 
		 * @param userid  用户Id
		 * @param request header中保存tokenid
		 * @return	2.	[get]/oauth/users/{id}			返回指定用户详情
		 */
		@RequestMapping(value="{id}",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult named_user(@PathVariable(value="id") String userid,HttpServletRequest request){
			if(userid==null){
				return null;
			}
			XoadoResult result = iUser.named_user(userid, request);
			return result;	
		}
		/**
		 * 
		 * @param userid 用户Id
		 * @param request  header中保存tokenid
		 * @return [get]/oauth/users?id=     返回指定用户详情
		 */
		@RequestMapping("/")
		@ResponseBody
		public XoadoResult named_id(@RequestParam(value="userid") String userid,HttpServletRequest request){
			XoadoResult result = iUser.named_user(userid, request);
			return result;	
		}
		/**
		 * 
		 * @param userid	用户Id
		 * @param request	 header中保存tokenid
		 * @return [get]/oauth/users/{ID}/headimg   指定ID用户头像
		 */
		@RequestMapping(value="{id}/headimg",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult appoint_head(@PathVariable("id") String userid,HttpServletRequest request){	
			return iUser.appoint_head(userid, request);
		}
		/**
		 * 
		 * @param userid 	用户Id
		 * @param request	 header中保存tokenid
		 * @return	[get]/oauth/users/headimg?id= 指定ID用户头像
		 */
		@RequestMapping(value="/idheadimg",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult id_head(@RequestParam("userid") String userid,HttpServletRequest request){	
			return iUser.appoint_head(userid, request);
		}
		/**
		 * 
		 * @param request
		 * @return 3.	[get]/oauth/users/headimg     当前用户头像
		 */
		@RequestMapping(value="headimg",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult present_head(HttpServletRequest request){
			return iUser.present_head(request);	
		}
	
		/**
		 * 
		 * @param idcard
		 * @param positiveImgUrl
		 * @param reverseImgUrl
		 * @param name
		 * @param request
		 * @return  8.	[post]/oauth/users/authentications     提交实名认证资料
		 */
		@RequestMapping(value="/authentications",method=RequestMethod.POST)
		@ResponseBody
		public XoadoResult user_certification(String idcard,
				@RequestParam("positiveImgUrl") MultipartFile positiveImgUrl,
				@RequestParam("reverseImgUrl") MultipartFile reverseImgUrl,String name,HttpServletRequest request){
					return iUser.Certification(idcard,positiveImgUrl, reverseImgUrl, name, request);	
		}
	
		/**
		 * 
		 * @param request
		 * @return 7.	[get]/oauth/users/authentications    获得当前用户实名认证信息
		 */
		@RequestMapping(value="/authentications",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult me_authentications(HttpServletRequest request){
			XoadoResult result = iUser.me_Certification(request);
			return result;
		}
		
		/**
		 * 
		 * @param userid
		 * @param request
		 * @return [get]/oauth/users/authentications?id=    获得指定用户实名认证信息
		 */
		@RequestMapping(value="authentication",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult named_authentications(@RequestParam("userid") String userid,HttpServletRequest request){
			XoadoResult result = iUser.named_Certification(userid, request);
			return result;	
		}
		/**
		 * 
		 * @param userid
		 * @param request
		 * @return  [get]/oauth/users/authentications/{id}    获得指定用户实名认证信息
		 */
		@RequestMapping(value="authentications/{id}",method=RequestMethod.GET)
		@ResponseBody
		public XoadoResult id_authentications(@PathVariable("id") String userid,HttpServletRequest request){
			XoadoResult result = iUser.named_Certification(userid, request);
			return result;
		}
		
		/**
		 * 
		 * @param nickName
		 * @param sex
		 * @param city
		 * @param country
		 * @param province
		 * @param request
		 * @return	4.	[put]/oauth/users      		 修改当前用户信息
		 */
		@RequestMapping(value="update",method=RequestMethod.PUT)
		@ResponseBody
		public XoadoResult  update_user(@RequestParam ("nickName") String nickName,
				@RequestParam ("sex") Long sex,
				@RequestParam ("city") String city,
				@RequestParam ("country") String country,
				@RequestParam ("province") String province,HttpServletRequest request){
			XoadoResult result = iUser.update_user(nickName, sex, city, country, province, request);
			return result;
		}
		/**
		 * 
		 * @param userId
		 * @param nickName
		 * @param sex
		 * @param city
		 * @param country
		 * @param province
		 * @param request
		 * @return 5.	[put]/oauth/users/{id}      	 修改指定ID 用户信息
		 */
		@RequestMapping(value="/{id}",method=RequestMethod.PUT)
		@ResponseBody
		public XoadoResult update_id_user(@PathVariable("id") String userId,@RequestParam ("nickName") String nickName,
				@RequestParam ("sex") Long sex,
				@RequestParam ("city") String city,
				@RequestParam ("country") String country,
				@RequestParam ("province") String province,HttpServletRequest request){
			XoadoResult result = iUser.update_id_user(userId, nickName, sex, city, country, province, request);
			return result;
		}
		
		/**
		 * 
		 * @param headImgUrl
		 * @param request
		 * @return 6.	[put]/oauth/users/headimg      更新当前用户头像
		 */
		@RequestMapping(value="/headimg",method=RequestMethod.PUT)
		@ResponseBody
		public XoadoResult update_user_headimgurl(@RequestParam ("headImgUrl") String headImgUrl,HttpServletRequest request){
			XoadoResult result = iUser.update_user_headimgurl(headImgUrl, request);
			return result;
		}
		
		/**
		 * 
		 * @param accounttype
		 * @param request
		 * @return 9.	[put]/oauth/users/type				改变当前用户类型
		 */
		@RequestMapping(value="/type",method=RequestMethod.PUT)
		@ResponseBody
		public XoadoResult update_type(@RequestParam("accounttype") String accounttype, HttpServletRequest request){
			XoadoResult result = iUser.update_type(accounttype, request);
			return result;
		}
		/**
		 * 
		 * @param userId
		 * @param accounttype
		 * @param request
		 * @return [put]/oauth/users/type/{id}			改变指定用户类型
		 */
		@RequestMapping(value="type/{id}")
		@ResponseBody
		public XoadoResult update_id_type(@PathVariable("id") String userId,String accounttype,HttpServletRequest request){
			XoadoResult result = iUser.update_id_type(userId, accounttype, request);
			return result;	
		}
}
