<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>500</title>
<style type="text/css">
</style>
</head>
<body>

	<p onclick="test()">代码测试页面</p>
	<script src="js/plugin/jquery-2.1.0.js" type="text/javascript"
		charset="utf-8"></script>
	<script>
		function test() {

			var datetime = new Date();
			// 			datetime.setTime(time);
			var year = datetime.getFullYear();
			var month = datetime.getMonth() + 1 < 10 ? "0"
					+ (datetime.getMonth() + 1) : datetime.getMonth() + 1;
			var date = datetime.getDate() < 10 ? "0" + datetime.getDate()
					: datetime.getDate();
			var hour = datetime.getHours() < 10 ? "0" + datetime.getHours()
					: datetime.getHours();
			var minute = datetime.getMinutes() < 10 ? "0"
					+ datetime.getMinutes() : datetime.getMinutes();
			var second = datetime.getSeconds() < 10 ? "0"
					+ datetime.getSeconds() : datetime.getSeconds();
			var s = year + "-" + month + "-" + date + " " + hour + ":" + minute
					+ ":" + second;
			alert(s);
		}

		window.onload = function() {

			var msg = $('#err-hide').html();
			if (confirm(msg)) {
				window.opener = null;
				window.open('', '_self');
				window.close();
			}
		};
	</script>
</body>

</html>
