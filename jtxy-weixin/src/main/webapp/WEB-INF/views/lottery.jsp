<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<title>幸运大转盘</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<style type="text/css">
input::-webkit-inner-spin-button {
	-webkit-appearance: none;
}

input::-webkit-outer-spin-button {
	-webkit-appearance: none;
}

body {
	padding: 0;
	margin: 0;
}

.main_pt {
	width: 80%;
	position: relative;
	margin: 0 auto;
}

.pointer {
	margin: 0 auto;
	position: absolute;
	top: 20%;
	left: 38%;
	width: 24%;
	height: 48%;
	cursor: pointer;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jQueryRotate.2.2.js"></script>
<script type="text/javascript" src="js/jquery.easing.min.js"></script>
<script>
	var degree = 0;
	// 	次数
	var time = 0;
	var is_working = 0;
	var mycode = '1q2w3e4r!@#$';
	function bodyonload() {

	}
	function toPlay() {
		//只需抽一次
		if (time >= 1) {
			alert("休息一会再来吧!");
			return;
		}
		$("#diskbtn").attr("style", "width:70%");
		var degree = '';
		var msg = '';
		$.ajax({
			url : "getdegree.json",
			type : "get",
			dataType : 'json',
			async : false,
			success : function(result) {
				degree = result.degree;
				msg = result.errMsg;
				time++;
			}
		});
		if (msg != 'success') {
			alert("系统繁忙..");
			return;
		}
		if (degree != null && degree != '') {
			var rotateAngle = 360 * 5 - degree;
			$("#diskbtn").css({
				"transform" : "rotate(" + rotateAngle + "deg)",
				"-webkit-transform" : "rotate(" + rotateAngle + "deg)",
				"-o-transform" : "rotate(" + rotateAngle + "deg)",
				"-moz-transform" : "rotate(" + rotateAngle + "deg)",
				"-webkit-transition" : "all ease 5s",
				"-otransition" : "all ease 5s",
				"-moz-transition" : "all ease 5s",
			});
			setTimeout(function() {
				if (degree > 45 && degree < 90) {
					$('#two').css('display', 'block');
					//alert('恭喜您，中了二等奖！');
				} else if (degree > 135 && degree < 180) {
					$('#three').css('display', 'block');
					//alert('恭喜您，中了三等奖！');
				} else if (degree > 225 && degree < 270) {
					$('#one').css('display', 'block');
					//alert('恭喜您，中了一等奖！');
				} else if (degree > 315 && degree < 360) {
					$('#four').css('display', 'block');
					//alert('恭喜您，中了幸运奖！');
				} else {
					$('#five').css('display', 'block');
				}
			}, 6000);
		}
		;

	}
	function openid(obb) {
		document.getElementById(obb).style.display = "block";
	}
	function turnoff(obj) {
		document.getElementById(obj).style.display = "none";
	}

	function searchresult() {
		$
				.ajax({
					type : "get",
					url : 'priceRecord.json',
					async : false,
					success : function(data) {
						var obj = '<div class="priceRecord"><div class="main_textbg"><div class="main_text"><div style="text-align: center;"><p><b>中奖纪录:</b></p>';

						var count = $('.priceRecord').length;

						if (data.priceRecordsAjaxResponse.list == null) {
							obj += '</div></div></div></div>';
							if (count > 0) {
								$("div").remove(".priceRecord");
							}
							$(obj).insertBefore($('#loadingMore'));
							return;
						} else {
							var Len = data.priceRecordsAjaxResponse.list.length;
							for (var i = 0; i < Len; i++) {
								var id = data.priceRecordsAjaxResponse.list[i].id;
								var uid = data.priceRecordsAjaxResponse.list[i].uid;
								var priceLevel = data.priceRecordsAjaxResponse.list[i].priceLevel;
								var createTime = data.priceRecordsAjaxResponse.list[i].createTime;
								var d = new Date(createTime);
								obj += '<p>' + formatDate(d)
										+ '&nbsp;&nbsp;&nbsp;' + priceLevel
										+ '</p>';
							}
							obj += '</div></div></div></div>';

							if (count > 0) {
								$("div").remove(".priceRecord");
							}
							$(obj).insertBefore($('#loadingMore'));
						}
					}
				});
	}

	function formatDate(datetime) {

		var year = datetime.getFullYear();
		var month = datetime.getMonth() + 1 < 10 ? "0"
				+ (datetime.getMonth() + 1) : datetime.getMonth() + 1;
		var date = datetime.getDate() < 10 ? "0" + datetime.getDate()
				: datetime.getDate();
		var hour = datetime.getHours() < 10 ? "0" + datetime.getHours()
				: datetime.getHours();
		var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes()
				: datetime.getMinutes();
		var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds()
				: datetime.getSeconds();
		return year + "-" + month + "-" + date + " " + hour + ":" + minute
				+ ":" + second;
	}

	$(function() {
		$("#startbtn").rotate({
			bind : {
				click : function() {
					toPlay();
				}
			}
		});
	});
</script>
</head>



<body>
	<!--主体div-->
	<div class="main_one" style="width: 100%; margin: 0 auto;">

		<!--大转盘界面div-->
		<div id="main" style="width: 100%">
			<div class="main_title">
				<img src="images/title.png" width="60%" />
			</div>
			<div style="width: 100%; height: 20px;"></div>
			<div class="monkey">

				<div style="clear: both;"></div>
			</div>
			<div class="msg" style="width: 100%;"></div>

			<!--底盘与时针div-->
			<div>
				<div class="demo" style="width: 100%:clear:both;">
					<div class="main_pt">
						<img src="images/lottrey_bg.png" id="diskbtn" style="width: 70%;" />
						<img class="pointer" src="images/lottrey_pointer1.png"
							id="startbtn" style="" />
					</div>
					<div style="clear: both;"></div>
				</div>
				<div style="clear: both;"></div>
			</div>

			<!--立即抽奖与中奖纪录按钮-->
			<div class="button_cj">
				<a href="javascript:void(0);" onclick="toPlay()">
					<img src="images/ljcj.png" width="40%" />
				</a>
				<a onClick="searchresult()">
					<img src="images/zjjl.png" width="40%" />
				</a>
			</div>

			<div id="loadingMore" align="center"></div>

		</div>
		<!--大转盘界面div  结束-->

		<!--活动介绍div-->
		<div class="hdgz">
			<div class="main_textbg">
				<div class="main_text">
					<div style="text-align: center;">
						<p>
							<b>活动介绍</b>
						</p>
					</div>
					<p>2016年4月20日起</p>
					<p>
						<b>一、活动对象：</b>
					</p>
					<p>南通大学绑定注册公众平台的用户</p>
					<p>
						<b>二、活动内容：</b>
					</p>
					<p>点击转盘抽奖即可获得相应奖品</p>
					<p>
						<b>三、奖品介绍：</b>
					</p>
					<p>一等奖：20积分</p>
					<p>二等奖：10积分</p>
					<p>一等奖：3积分</p>
					<p>一等奖：1积分</p>
					<p>
						如有疑问请致电
						<b>18362156503。</b>
					</p>
				</div>
			</div>
		</div>

	</div>
	<!--大转盘界面div  结束-->



	<!--一等奖div-->
	<div id="one" class="prize" style="display: none;">
		<div class="main_info">
			<div class="out">
				<a onClick="javascript:turnoff('one')">
					<img src="images/out.png" width="35" />
				</a>
			</div>
			<div style="height: 10px; width: 100%;"></div>
			<div class="info_div">
				<div class="center_div">
					<img src="images/coin1.png" width="40%" />
				</div>

				<div class="center_div">
					<img src="images/text1.png" width="70%" />
				</div>

				<div class="center_div jxcj">
					<a onClick="javascript:turnoff('one')">
						<img src="images/jxcj.png" width="60%;" />
					</a>
				</div>
			</div>
		</div>
	</div>

	<!--二等奖div-->
	<div id="two" class="prize" style="display: none;">
		<div class="main_info">
			<div class="out">
				<a onClick="javascript:turnoff('two')">
					<img src="images/out.png" width="35" />
				</a>
			</div>
			<div style="height: 10px; width: 100%;"></div>
			<div class="info_div">
				<div class="center_div">
					<img src="images/coin2.png" width="40%" />
				</div>

				<div class="center_div">
					<img src="images/text2.png" width="70%" />
				</div>

				<div class="center_div jxcj">
					<a onClick="javascript:turnoff('two')">
						<img src="images/jxcj.png" width="60%;" />
					</a>
				</div>
			</div>
		</div>
	</div>

	<!--三等奖div-->
	<div id="three" class="prize" style="display: none;">
		<div class="main_info">
			<div class="out">
				<a onClick="javascript:turnoff('three')">
					<img src="images/out.png" width="35" />
				</a>
			</div>
			<div style="height: 10px; width: 100%;"></div>
			<div class="info_div">
				<div class="center_div">
					<img src="images/coin1.png" width="40%" />
				</div>

				<div class="center_div">
					<img src="images/text3.png" width="70%" />
				</div>

				<div class="center_div jxcj">
					<a onClick="javascript:turnoff('three')">
						<img src="images/jxcj.png" width="60%;" />
					</a>
				</div>
			</div>
		</div>
	</div>

	<!--幸运奖div-->
	<div id="four" class="prize" style="display: none;">
		<div class="main_info">
			<div class="out">
				<a onClick="javascript:turnoff('four')">
					<img src="images/out.png" width="35" />
				</a>
			</div>
			<div style="height: 10px; width: 100%;"></div>
			<div class="info_div">
				<div class="center_div">
					<img src="images/coin2.png" width="40%" />
				</div>

				<div class="center_div">
					<img src="images/text4.png" width="70%" />
				</div>

				<div class="center_div jxcj">
					<a onClick="javascript:turnoff('four')">
						<img src="images/jxcj.png" width="60%;" />
					</a>
				</div>
			</div>
		</div>
	</div>

	<!--未中奖div-->
	<div id="five" class="prize" style="display: none;">
		<div class="main_info">
			<div class="out">
				<a onClick="javascript:turnoff('five')">
					<img src="images/out.png" width="35" />
				</a>
			</div>
			<div style="height: 10px; width: 100%;"></div>
			<div class="info_div">
				<div class="center_div">
					<img src="images/coin3.png" width="40%" />
				</div>

				<div class="center_div">
					<img src="images/text5.png" width="70%" />
				</div>

				<div class="center_div jxcj">
					<a onClick="javascript:turnoff('five')">
						<img src="images/jxcj.png" width="60%;" />
					</a>
				</div>
			</div>
		</div>
	</div>
</body>