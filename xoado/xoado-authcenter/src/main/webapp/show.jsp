<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>焦点图</title>
		<link rel="stylesheet" href="css/show.css" />
		<script src="js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		
		<div id="box">
			<div id="img-box">
				<img src="img/show0.jpg" />
			</div>
		</div>
		<div id="turn-box">
			<span id="left"></span>
			<span id="right"></span>
		</div>
		<script type="text/javascript">
			$(function(){
				var timer;
				var n=0;

//-----------------		箭头换图         ----------------
				$("#left").click(function(){
					if (n>0) {
						n-=1;//n=n-1
					} else{
						n=3;
					}
					$("img").attr("src","img/show"+n+".jpg")
				})
				$("#right").click(function(){
					if (n<3) {
						n+=1;//n=n-1
					} else{
						n=0;
					}
					$("img").attr("src","img/show"+n+".jpg")
				})
			})
		</script>
	</body>
</html>