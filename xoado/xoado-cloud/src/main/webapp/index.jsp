<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/common/sendsms" method="post">
		签名<input type="text" name="text">
		<input type="text" name="xoado_message">
		<input type="text" name="phoneNumber">
		<input type="text" name="code">
		<input type="submit" value="test">
	</form>
	
</body>
</html>