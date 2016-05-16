<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>作品上传</title>
<link rel="stylesheet" href="css/reset.css" />
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
	height: 0.84rem;
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
	padding-left: -2.116rem;
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

#stuNo {
	opacity: 0;
}

.input_file {
	position: absolute;
	display: inline-block;
	width: 0.7rem;
	height: 0.115rem;
	line-height: 0.115rem;
	background-color: #3EA45A;
	color: #fff;
	border-radius: 6px;
	position: relative;
	left: -0.15rem;
}
</style>
</head>
<body>
	<div class="headerWrap" id="uploadImage">
		<canvas id="canvas"></canvas>
	</div>
	<div class="content">
		<form action="uploadWorks.htm" name="uploadForm" id="uploadForm"
			method="post" enctype="multipart/form-data">
			<ul class="list">
				<li>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="file" name="uploadFile" id="uploadFile"
						onchange="processFile(this.files[0])">
				</li>
				<li>
					作品名称：
					<input type="text" name="workName" id="workName" value=""
						placeholder="请输入作品名称" />
				</li>
				<li>
					作品描述：
					<input type="text" name="workDesc" id="workDesc" value=""
						placeholder="作品描述" />
				</li>
				<li>
					<button type="button" class="btn-connect" id="btn-connect">上传</button>
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
			if ($('#workName').val() == '') {
				$('.error-msg').html('名字不能为空!');
				$('#err-hide').html('');
				return false;
			}
			if ($('#workDesc').val() == '') {
				$('.error-msg').html('描述不能为空!');
				$('#err-hide').html('');
				return false;
			} else {
				$('.error-msg').html('');
				$('#uploadForm').submit();
			}
		});

		if ($('#err-hide').html() == '上传成功！') {
			$('#err-hide').css('color', '#3EA45A');
		} else {
			$('#err-hide').css('color', 'red');
		}
	});

	function processFile(file) {
		if (window.FileReader) {
			var fr = new FileReader();
			var reader = new FileReader();
			var fileType = file.type;
			var index = fileType.indexOf('/');

			var extName = fileType.substring(index + 1, fileType.length);
			console.log(extName);

			if (extName != 'jpg' && extName != 'jpeg' && extName != 'png'
					&& extName != 'bmp' && extName != 'gif') {
				alert("请上传图片哟！");
				return;
			}
			;
			reader.onload = function(e) {
				//alert(e.target.result);
				$('#canvas')[0].src = e.target.result;
				read(e.target.result);
			};
			reader.readAsDataURL(file);

		} else {
			alert("Not supported by your browser，上方图片可能无法预览");
		}
	}

	function read(DateURl) {
		var image = new Image();
		image.onload = function() { //先要绑定load事件
			resize(image, 300, 300);
			var canvas = document.getElementById("canvas");
			var ctx = canvas.getContext('2d');
			canvas.width = image.width;
			canvas.height = image.height;

			ctx.clearRect(0, 0, image.width, image.height);
			ctx.drawImage(image, 0, 0, image.width, image.height);

			var file_base64 = canvas.toDataURL('image/jpeg', 0.8);
		};
		image.src = DateURl;
	};

	function resize(image, max_width, max_height) { //图片缩放的函数
		var Ratio = 1;//图片的缩放比例
		var w = image.width;
		var h = image.height;

		//宽度的缩放比例
		var wRatio = max_width / image.width;
		//高度的缩放比例
		var hRatio = max_height / image.height;

		if (max_width == 0 && max_height == 0) { //不缩放
			Ratio = 1;
		} else if (max_width == 0) { //缩放高度
			if (hRatio < 1) {
				Ratio = hRatio;
			}
		} else if (max_height == 0) { //缩放宽度
			if (wRatio < 1) {
				Ratio = wRatio;
			}
		} else if (wRatio < 1 && hRatio < 1) {
			Ratio = (wRatio <= hRatio ? wRatio : hRatio);
		}
		w = w * Ratio;
		h = h * Ratio;
		image.width = w;
		image.height = h;
	}
</script>
</html>
