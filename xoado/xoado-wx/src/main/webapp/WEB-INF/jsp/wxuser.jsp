<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
		
		
					<c:forEach items="${WXUSER }" var="A" >
							<tr>           
								<td>用户的唯一标识     	  							 ${A.openid }</td><br>
								<td>用户昵称               		  							 ${A.nickname }</td><br>
								<td>用户的性别，              	   							 ${A.sex }</td><br>
								<td>用户个人资料填写的省份   							 ${A.province }</td><br>
								<td>普通用户个人资料填写的城市						 ${A.city }</td><br>
								<td>国家，如中国为CN									 ${A.country	 }</td><br>
								<td>用户头像											 ${A.headimgurl	 }</td><br>
								<td>用户特权信息										 ${A.privilege	 }</td><br>
								<td>用户将公众号绑定到微信开放平台才会出现该字段		 ${A.unionid	 }</td>
							</tr>
					</c:forEach>
		
	
</body>
</html>