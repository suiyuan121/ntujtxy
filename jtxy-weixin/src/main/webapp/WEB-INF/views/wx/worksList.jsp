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

<link rel="stylesheet" media="screen" type="text/css"
	href="css/works/reset.css">
<link rel="stylesheet" media="screen" type="text/css"
	href="css/works/main.css">
<title>优秀作品展示</title>

<style>
#wrapper {
	border: 3px solid #12C3EC;
}

#topstory img {
	/*width:99.5%;*/
	
}
</style>
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

		<ul class="list box">
			<c:forEach items="${pageList.resultList}" var="item"
				varStatus="status">
				<li class="box" onclick="showContent(${item.id})">
					<div class="list-img ">
						<a>
							<img id="firstimg1" src="${item.url}" alt="">
						</a>
					</div>
					<div class="list-txt">
						<h3>
							<a id="new1">${item.workName}</a>
							<br>
						</h3>
					</div>
					<div class="list-txt">
						<h3>
							<a id="new1">${item.workDesc}</a>
						</h3>
					</div>
					<br>
					<div class="list-txt">
						<h3>
							<a id="new1" style="color: red;">评论(${item.commentAmount})
								赞(${item.supportsAmount})</a>
						</h3>
					</div>
				</li>
			</c:forEach>
			<c:choose>
				<c:when
					test="${imagesPageQueryForm.currentPage==imagesPageQueryForm.pageNum||imagesPageQueryForm.pageNum==0}">
					<p id="noRecord" align="center">没有记录...</p>
				</c:when>
				<c:otherwise>
					<div id="loadingMore" align="center">点击加载更多...</div>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
<script src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	var currentPage = $('#currentPage').val();
	var pageNum = $('#pageNum').val();

	$('#loadingMore').on('click', function() {
		$(this).html('正在加载...');
		getList();
	});

	function getList() {
		currentPage++;

		if (pageNum < currentPage) {
			alert("0000");
			$('#loadingMore').html('没有更多数据了...');
			$('#loadingMore').off('click');
			return;
		}
		$
				.ajax({
					type : "get",
					url : 'imagesQuery.json' + '?' + 'currentPage='
							+ currentPage,
					async : true,
					success : function(data) {
						if (data.imagesQueryAjaxResponse.list == null) {
							$('#loadingMore').html('没有更多数据了...');
							$('#loadingMore').off('click');
							return;
						} else {
							var Len = data.imagesQueryAjaxResponse.list.length;
							if (Len < 2) {
								$('#loadingMore').html('没有更多数据了...');
								$('#loadingMore').off('click');
							} else {
								$('#loadingMore').html('点击加载更多...');
							}
							var oLi = '';
							for (var i = 0; i < Len; i++) {
								var id = data.imagesQueryAjaxResponse.list[i].id;
								var url = data.imagesQueryAjaxResponse.list[i].url;
								var workName = data.imagesQueryAjaxResponse.list[i].workName;
								var workDesc = data.imagesQueryAjaxResponse.list[i].workDesc;
								var supportsAmount = data.imagesQueryAjaxResponse.list[i].supportsAmount;
								var commentAmount = data.imagesQueryAjaxResponse.list[i].commentAmount;

								oLi += ' <li class="box" onclick="showContent('+id+')" id="newend1"><div class="list-img "> <a>'
										+ '  <img id="firstimg1" src="'+url+'" alt=""> </a></div><div class="list-txt"><h3>'
										+ ' <a id="new1">'
										+ workName
										+ ':'
										+ workDesc
										+ '</a></h3></div><div class="list-txt"><h3>'
										+ ' <a id="new1" style="color: red;">评论('
										+ commentAmount
										+ ')'
										+ '赞('
										+ supportsAmount
										+ ')</a></h3></div></li>';

							}
							$(oLi).insertBefore($('#loadingMore'));
						}
					}
				});
	};

	function showContent(id) {
// 		alert(id);
		location.href = "showWorksContent.htm?id="+id;//location.href实现客户端页面的跳转  
	};
</script>
</html>