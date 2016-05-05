<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="cn.edu.ntu.jtxy.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="keywords" content="交通学院微信管理平台" />
<meta name="description" content="连接你我" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/emng-1.0.0.css" />
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/myPage.css" />

<!--theme-->
<link rel="stylesheet" type="text/css"
	href="css/theme-origin/emng-origin.css" />
<link rel="stylesheet" type="text/css"
	href="css/theme-origin/public-origin.css" />
<title>新闻管理</title>
<style type="text/css">
nav em {
	background-position: -300px 2px;
}

.check-factor-wrapper .check-factor-1 li .emng-select,.check-factor-wrapper .check-factor-1 li .emng-select select
	{
	width: 200px;
	margin-left: 10px;
}

.check-factor-wrapper .check-factor-1 li .emng-select .emng-curselect {
	width: 168px;
}
</style>
</head>
<body>
	<nav class="emng-flex">
		<em></em>
		<p>
			文本通知群发 -> <span>推送文本通知</span>
		</p>
	</nav>
	<div class="check-factor-wrapper">
		<article>选择群发人员</article>
		<form name="pushTextForm" id="pushTextForm" action="textPush.htm"
			method="post">
			<div class="check-factor-1 emng-flex">
				<ul class="emng-flex">
					<li><span>群发对象:</span> <a class="emng-select"> <strong
							class="emng-curselect"></strong> <select
							onchange="change($(this))" name="year" class="loc">
								<option value="10" selected="selected">全部</option>
								<option value="12">12届</option>
								<option value="13">13届</option>
								<option value="14">14届</option>
								<option value="15">15届</option>
								<option value="16">16届</option>
								<option value="17">毕业生</option>
						</select>
					</a> <input type="hidden" name="content" value="" id="content">
					</li>
				</ul>
				<div class="check-search-wrapper emng-flex">
					<button class="emng-btn btn-bg-blue" type="submit"
						id="pushNews-button">群发</button>
				</div>
			</div>
			<label id="submitReturn" style="display: none;">${msg}</label>

		</form>
	</div>
	<div class="check-factor-wrapper">
		<article>编辑内容</article>
		<div class="check-factor-1 emng-flex">
			<ul class="emng-flex">
				<li><textarea name="sendContent" cols="143" rows="20"
						id="sendContent"></textarea></li>
			</ul>
		</div>
	</div>
</body>
<script src="js/plugin/jquery-2.1.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/vertifycate.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/select-changes.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/noty.js" type="text/javascript" charset="utf-8"></script>
<script src="js/main/org-infoEdit.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/pagination.js" type="text/javascript"></script>

<script type="text/javascript">
	$('#pushNews-button').click(function() {
		var text = $('#sendContent').val();
		if (text == '') {
			alert("文本内容不能为空！");
			return false;
		} else {
			if (confirm('您确定要群发吗')) {
				$('#content').val(text);
				$('#pushNewsForm').submit();
			}
		}
	});

	window.onload = function() {
		if ($('#submitReturn').length != 0) {
			var Msg = $('#submitReturn').html();
			if (Msg != '') {
				var opt = {
					'text' : Msg,
					'layout' : 'top'
				};
				noty(opt);
			}
		}
		;
	};
</script>
</html>
