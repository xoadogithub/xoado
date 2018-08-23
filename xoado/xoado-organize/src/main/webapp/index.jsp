 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="oauth/users/update" method="post">
		昵称<input type="text" name="nickName"><br>
		性别<input type="text" name="sex"><br>
		城市<input type="text" name="city"><br>
		国家<input type="text" name="country"><br>
		省份<input type="text" name="province"><br>
		<input type="submit" value="更新">
	</form>
	------------------------------创建组织--------------------------------
	<form action="/organizations/" method="post">
		服务组织名称<input type="text" name="organizeName"><br>
		
		组织地址<input type="text" name="address"><br>
		组织电话<input type="text" name="telephone"><br>
		组织类型<input type="text" name="orgId"><br>
		组织智能领域<input type="text" name="scode"><br>
		统一社会信用代码<input type="text" name="usci"><br>
	
		<input type="submit" value="创建组织">
	</form>
	--------------------------------------------------
	<form action="/applications/" method="post">
		组织Id<input type="text" name="organizeId"><br>
		应用名称<input type="text" name="appName"><br>
		应用类型<input type="text" name="appType"><br>
		应用说明<input type="text" name="description"><br>
		<input type="submit" value="创建应用">
	</form>
	--------------------------------------------------
	<form action="/apis" method="post">
		应用ID<input type="text" name="appId">     示例：123<br>
		域名后路径<input type="text" name="apiPath">	 示例 /abc/{abc}   /abc/cba<br>
		请求方式<input type="text" name="requestMethod">	示例 0  1  2  3<br>
		接口所需header头信息<input type="text" name="header">  头文件需要传的参数   示例  token   cookies   method<br>
		接口描述<input type="text" name="description">	示例 ： 展示指定的用户信息  参数：userid=用户id   userphone=电话<br>
		接口所需参数<input type="text" name="parameter">	示例 userid=123&phone=123<br>
		<input type="submit" value="增加"> 
	</form>
	
</body>
</html>