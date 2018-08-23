<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
获取短信验证码
	<form action="access/login/sendsms" method="post">
		<input type="text" name="phoneNumber">
		<input type="submit" value="获取手机验证码">
	</form>
	密码登录
	<form action="access/login/account_Login" method="post">
		<input type="text" name="phoneNumber">
		<input type="password" name="userPassword">
		<input type="submit" value="登录">
	</form>
	验证码-有/登录
		<form action="/xoado/access/login/VerificationCcode_login" method="post">
		<input type="text" value="点击获取验证码获取验证码" name="phoneNumber">
		<input type="text" name="Verification_code">
		<input type="submit" value="登录">
	</form>
	验证码-无/登录
		<form action="xoado/access/login/VerificationCcode_login" method="post">
		<input type="text" value="点击获取验证码获取验证码" name="phoneNumber">
		<input type="text" name="Verification_code">
		<input type="submit" value="登录">
	</form>
	注册
		<form action="xoado/access/login/userRegister" method="post">
		手机号：<input type="text" name="phoneNumber"><br>
		验证码：<input type="text" name="Verification_code"><br>
		密码：<input type="password" name="userPassword"><br>
		<input type="submit" value="注册">
		</form>
		微信手机绑定
		<form action="/access/wxlogin/register_phone" method="post">
		<input type="text" name="openId"><br>
		<input type="text" name="phoneNumber"><br>
		<input type="text" name="Verification_code"><br>
		<input type="submit" value="绑定手机">
		</form>
</body>
</html>