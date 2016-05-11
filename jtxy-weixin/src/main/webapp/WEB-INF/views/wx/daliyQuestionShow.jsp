<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>学号绑定</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/radioStyle.css" />
<script type="text/javascript">
	document.getElementsByTagName('html')[0].style.fontSize = document.documentElement.clientWidth
			+ 'px';
</script>
<style type="text/css">
html,body {
	width: 100%;
}

body {
	background: #EDEBE9;
}

.headerWrap {
	width: 100%;
	height: 0.54rem;
	background: #FEFEFE;
	text-align: center;
	position: relative;
}

.headerWrap:after {
	position: absolute;
	width: 0;
	height: 0;
	overflow: hidden;
	border-left: 20px solid transparent;
	border-right: 20px solid transparent;
	border-bottom: 20px solid #EDEBE9;
	content: '';
	bottom: 0;
	left: 0.18rem;
}

.headerWrap img {
	margin-top: 0.073rem;
}

.headerWrap p {
	font-size: 0.039rem;
	color: #3C3C3C;
	line-height: 0.05rem;
	text-align: left;
	text-indent: 0.1rem;
	letter-spacing: 3px;
	padding: 0.04rem 0.06rem 0 0.06rem;
	font-family: "黑体";
}

.content {
	width: 100%;
	text-align: center;
}

.content li {
	
}

.content li span {
	color: red;
}

.content li:nth-of-type(1) {
	margin-top: 0.088rem;
}

.content li:nth-of-type(2) {
	margin-top: 0.07rem;
}

.content li:nth-of-type(3) {
	margin-top: 0.07rem;
}

.content li:nth-of-type(4) {
	margin-top: 0.05rem;
}

.content #stuNo,.content #pwd,.content #btn-connect {
	width: 0.80rem;
	height: 0.115rem;
	border-radius: 6px;
	outline: none;
	border: none;
	padding-left: 0.016rem;
}

.content #btn-connect {
	background: #3EA45A;
	color: #fff;
	font-family: "黑体";
	font-size: 16px;
	width: 0.82rem;
	padding: 0;
	-webkit-transition: .3s;
	transition: .3s;
}

.content #btn-connect:active {
	background: #348148;
}
</style>
</head>
<body>
	<div class="headerWrap">
		<p>今日问题：${dailyQuestionDo.content}</p>
	</div>
	<div class="content">
		<form action="daliyQuestionShow.htm" name="answerForm" id="answerForm"
			method="post">
			<ul class="list">
				<li>
					<input type="radio" id="radio-2-1" name="answer"
						class="regular-radio big-radio" value="${answers[0]}" />${answers[0]}
					<label for="radio-2-1"></label>
					<br />
				</li>
				<li>
					<input type="radio" id="radio-2-2" name="answer"
						class="regular-radio big-radio" value="${answers[1]}" />${answers[1]}
					<label for="radio-2-2"></label>
					<br />
				</li>
				<li>
					<input type="radio" id="radio-2-3" name="answer"
						class="regular-radio big-radio" value="${answers[2]}" />${answers[2]}
					<label for="radio-2-3"></label>
					<br />
				</li>
				<li>
					<input type="radio" id="radio-2-4" name="answer"
						class="regular-radio big-radio" value="${answers[3]}" />${answers[3]}
					<label for="radio-2-4"></label>
					<br />
				</li>
			</ul>
			<ul>
				<li>
					<button type="button" class="btn-connect" id="btn-connect">提交</button>
				</li>
				<li>
					<span class="error-msg"></span>
				</li>
				<li>
					<label id="err-hide">${errMsg}</label>
				</li>
			</ul>
		</form>

	</div>
</body>
<script src="js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn-connect').on('click', function() {

			var choice = $("input[name='answer']:checked").val();
			if (choice == '') {
				$('.error-msg').html('请选择一个答案选项！');
				$('#err-hide').html('');
				return false;
			} else {
				$('.error-msg').html('');
				$('#answerForm').submit();
			}
		});

		if ($('#err-hide').html() == '回答正确！') {
			$('#err-hide').css('color', '#3EA45A');
		} else {
			$('#err-hide').css('color', 'red');
		}
	});
</script>
</html>
