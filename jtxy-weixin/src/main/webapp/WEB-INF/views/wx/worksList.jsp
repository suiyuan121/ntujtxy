<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html style="height: 449px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品展示</title>
<meta http-equiv="content-language" content="en">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="-1">

<link rel="apple-touch-icon"
	href="http://210.29.65.230/html/haishi_news/06-news/images/icon.png">
<link rel="apple-touch-startup-image"
	href="http://210.29.65.230/html/haishi_news/06-news/images/splash.png">

<link rel="stylesheet" media="screen" type="text/css"
	href="css/works/reset.css">
<link rel="stylesheet" media="screen" type="text/css"
	href="css/works/main.css">
<script type="text/javascript" src="css/works/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="css/works/main.js"></script>
<script type="text/javascript" src="css/works/url.js"></script>


<title></title>
<style>
/*#content .separator{
    text-shadow:none;
}*/
/*#h3shadow{
    text-shadow:none;
}*/
#wrapper {
	border: 3px solid #12C3EC;
}

#topstory img {
	/*width:99.5%;*/
	
}
</style>
<script type="text/javascript">
	$(function() {

		// $(".separator").attr("text-shadow"," 1px 1px 0px #F3E4E4");
	})

	function getJsonObjLength(jsonObj) {
		var Length = 0;
		for ( var item in jsonObj) {
			Length++;
		}
		return Length;
	}

	function li_onclick(event) {
		// var j=18+event.data.index;
		// console.log("j:"+j);
		// this.clickFun=function() {

		window.location.href = "article.html?" + event.data.index;
		console.log("article.html?" + event.data.index);
	}
	// }

	$(
			function() {

				// var url="http://210.29.65.230:8080";
				var url = urllazy;
				var page = 1;

				function showmoreload() {

					page += 1;
					// console.log(page);
					$
							.ajax({
								type : "POST",
								url : url + "/qcstyle/title",
								dataType : "json",
								crossDomain : true,
								data : {
									page : page
								},
								success : function(jsonResult) {
									//var usersnum=getJsonObjLength(jsonResult.users)

									console.log("page:" + page);
									if (page >= jsonResult.totalpage) {
										//                       $("#loadmore").text("返回首页");
										// $("#loadmore").attr('href','#');
										var num = jsonResult.left;

										for (var i = 0; i < num; i++) {
											var articlePic = "";
											var newleft = (page - 1) * 5 + i;
											var a = newleft - 1;
											// articlePic="article-"+newleft+".jpg";

											console.log("newleft:" + newleft);
											console.log(jsonResult.users[i])
											$("#newend" + a)
													.after(
															"<div id=\"colordiv\"><li id="+"newend"+newleft+" class=\"box\"><div  class=\"list-img\"><a ><img src=\"images/"+jsonResult.users[i]["imgurl"]+"\" alt=\"\" /></a></div><div class=\"list-txt\"><h3 ><a id=new"
																	+ newleft
																			.toString()
																	+ ">"
																	+ jsonResult.users[i].title
																	+ "</a></h3></div></li></div>");

											// $("#new"+newleft.toString()).attr('href','article.html?'+jsonResult.users[i].id.toString());
											var lia = '#newend'
													+ newleft.toString();
											$(lia).bind('click', {
												index : jsonResult.users[i].id
											}, li_onclick)

										}

									}
									// alert($("#newend").attr("class"));
									else {//还有数据
										console.log("还有数据");
										var newfinnal = "";
										var articlePic = "";
										//定义5条
										for (var i = 0; i < 5; i++) {

											var newendid = (page - 1) * 5 + i;
											var a = newendid - 1;
											console.log("newendid:" + newendid);
											if (newendid < 10) {
												// articlePic="article-0"+newendid+".jpg";
												// console.log(articlePic);
												console
														.log(jsonResult.users[0])
												$("#newend" + a)
														.after(
																"<div id=\"colordiv\"><li id="+"newend"+newendid+" class=\"box\"><div  class=\"list-img\"><a ><img src=\"images/"+jsonResult.users[i]["imgurl"]+"\" /></a></div><div class=\"list-txt\"><h3 ><a id=new"
																		+ newendid
																				.toString()
																		+ ">"
																		+ jsonResult.users[i].title
																		+ "</a></h3></div></li></div>")

												// $("#new"+newendid.toString()).attr('href','article.html?'+jsonResult.users[i].id.toString());
												var lia = '#newend'
														+ newendid.toString();
												$(lia)
														.bind(
																'click',
																{
																	index : jsonResult.users[i].id
																}, li_onclick)
											} else {

												//      articlePic="article-"+newendid+".jpg";

												// console.log(articlePic);

												console
														.log(jsonResult.users[0])
												$("#newend" + a)
														.after(
																"<div id=\"colordiv\"><li id="+"newend"+newendid+" class=\"box\"><div  class=\"list-img\"><a ><img src=\"images/"+jsonResult.users[i]["imgurl"]+"\"/></a></div><div class=\"list-txt\"><h3 ><a id=new"
																		+ newendid
																				.toString()
																		+ ">"
																		+ jsonResult.users[i].title
																		+ "</a></h3></div></li></div>")

												// $("#new"+newendid.toString()).attr('href','article.html?'+jsonResult.users[i].id.toString());

												var lia = '#newend'
														+ newendid.toString();
												$(lia)
														.bind(
																'click',
																{
																	index : jsonResult.users[i].id
																}, li_onclick)

											}

										}
									}

								},

								error : function(jqXHR, textStatus) {

								}
							})

				}

				// console.log("latestnote:"+$("#latestnote").height());
				//if(parseInt($(window).scrollTop())!=0)
				//{
				//alert(" reset");
				// document.body.scroll(0,0) 
				//}

				var lazyheight = 0;
				// console.log(parseInt($(window).scrollTop())==0);
				// console.log(typeof($(window).scrollTop()));

				$(window).bind(
						"scroll",
						function() {
							// console.log( "winscroll:"+parseFloat($(window).scrollTop()));

							lazyheight = parseFloat($(window).height())
									+ parseFloat($(window).scrollTop());
							//获取当前窗体的高度+当前滚动条滚动的距离
							// console.log("lazyheight:"+lazyheight.toString());
							// console.log("height:"+($(document).height()-20).toString());
							if ($(document).height() <= lazyheight) {
								//当前文档的高度
								console.log("loadscrolling........");

								//当滚动条滚动时
								showmoreload();
							}
						});

				$
						.ajax({
							type : "POST",
							url : url + "/qcstyle/title",
							dataType : "json",
							crossDomain : true,
							data : {
								page : "1"
							},
							success : function(jsonResult) {

								if (jsonResult.success == "none") {
									alert("当前没有新闻");
								} else {

									var usersnum = getJsonObjLength(jsonResult.users)
									// alert(usersnum);
									console.log(usersnum);
									// $("#new0").text("头条"+jsonResult.users[0].title);
									for (var i = 0; i < usersnum; i++) {
										// $("#new"+newnum).val();
										// console.log(jsonResult.users[i].imgurl+jsonResult.users[i].title);

										// var imgurltostr='images/'+jsonResult.users[i].imgurl;
										// console.log($("#new0"));

										$("#new" + i.toString()).text(
												jsonResult.users[i].title);
										$("#firstimg" + i.toString())
												.attr(
														'src',
														'images/'
																+ jsonResult.users[i].imgurl);
										// $("#firstimg"+i.toString()).attr('href','article.html?'+jsonResult.users[i].id.toString());
										// $("#new"+i.toString()).attr('href','article.html?'+jsonResult.users[i].id.toString());
										// var urlimg=jsonResult.users[i].imgurl;
										var lia = '#newend' + i.toString();
										$(lia).bind('click', {
											index : jsonResult.users[i].id
										}, li_onclick)
									}

								}

							},
							error : function(jqXHR, textStatus) {
								alert("false");
							}
						})

			})
</script>

</head>

<body>
	<div id="wrapper">
		<!-- HEADER -->
		<div id="header" style="background-color: #21A4C2">
			<h3 id="logo" style="text-align: center">
				<font color="yellow">优秀作品展示</font>
			</h3>
		</div>
		<div class="dataRange">
			<form name="queryForm" id="queryForm" method="post"
				action="worksList.htm">
				<div class="check-factor-1 emng-flex">
					<ul class="emng-flex">
						<li>
							<input type="hidden" name="currentPage" id="currentPage"
								value="${imagesPageQueryForm.currentPage}" />
							<input type="hidden" id="pageNum" name="pageNum"
								value="${imagesPageQueryForm.pageNum}">
						</li>
					</ul>
				</div>
			</form>
		</div>

		<!-- CONTENT -->
		<div id="content" style="background-color:">
			<c:forEach items="${pageList.resultList}" var="item"
				varStatus="status">
				<div id="newend0">
					<div id="topstory">
						<a>
							<img id="firstimg0" style="height: 200px" src="${item.url}"
								alt="">
						</a>
					</div>
				</div>

				<!-- RECENT ARTICLES -->
				<h3 class="separator"
					style="background: #5bc0ca; text-shadow: 0px 0px 0px;"
					id="h3shadow">
					<!-- #5bc0ca -->
					最受欢迎作品:
					<font id="new0" style="color: white; text-shadow: 0px 0px 0px;">${item.workName}:${item.workName}</font>
				</h3>
				<ul class="list box">
					<li class="box" onclick="" id="newend1">

						<div class="list-img ">
							<a>
								<img id="firstimg1" src="${item.url}" alt="">
							</a>
						</div>
						<div class="list-txt">
							<h3>
								<a id="new1">${item.workName}:${item.workName}</a>
							</h3>
						</div>
					</li>
				</ul>
			</c:forEach>

			<c:choose>
				<c:when test="${pageList.totalCount == 0}">
					<p id="noRecord">没有记录...</p>
				</c:when>
				<c:otherwise>
					<div id="loadingMore">点击加载更多...</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>