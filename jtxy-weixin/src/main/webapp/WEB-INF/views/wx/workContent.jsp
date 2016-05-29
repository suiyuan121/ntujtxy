<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="cn.edu.ntu.jtxy.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html style="height: 643px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品详情</title>
<meta http-equiv="content-language" content="en">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<link rel="stylesheet" media="screen" type="text/css"
	href="css/works/reset.css">
<link rel="stylesheet" media="screen" type="text/css"
	href="css/works/main.css">

<style>
p {
	text-indent: 2em;
}

h2 {
	/*text-indent:2em;*/
	
}

.width100 img {
	height: 500px
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header" style="background-color: #21A4C2">
			<h3 id="logo">
				<font color="yellow">作品详情</font>
			</h3>
		</div>
		<div id="content">
			<div class="padding" style="margin-left: 5px">
				<h2 class="title" id="title" style="margin-left:">${imagesDo.workName}</h2>
				<input type="hidden" value="${imagesDo.id}" id="imageId"
					name="imageId">
				<p class="nomt grey" id="gettime" style="text-indent: 0em;">${date}&nbsp;&nbsp;&nbsp;
					<span id="prise">
						点赞(
						<a id="amount">${imagesDo.supportsAmount}</a>
						)
						<input type="hidden" value="false" id="isPrise" name="isPrise">
					</span>
				</p>
				<div class="width100">
					<a>
						<img id="getimg" src="${imagesDo.url}" alt="">
					</a>
				</div>

				<div id="newcontent" style="margin: auto;"></div>
				<p>${imagesDo.workDesc}</p>
			</div>
		</div>
	</div>
</body>

<script src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$('#prise').on(
			'click',
			function() {
				// 				alert('点赞啦')
				var supportAmount = parseInt($('#amount').html());
				var imageId = $('#imageId').val();
				var isPrise = $('#isPrise').val();
				if (isPrise == 'true') {
					alert("只能赞一次哦");
					return;
				}
				$.ajax({
					type : "get",
					url : 'prise.json' + '?' + 'supportAmount=' + supportAmount
							+ '&imageId=' + imageId,
					async : false,
					success : function(result) {
						var msg = result.msg;
						// 						alert('data is :' + msg);
						if (msg != 'success') {
							return;
						} else {
							$('#amount').html(supportAmount + 1);
							$('#isPrise').val('true');
							return;
						}
					}
				});
			});
</script>
</html>