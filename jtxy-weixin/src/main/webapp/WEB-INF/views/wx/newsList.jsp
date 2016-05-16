<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="height: 449px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻列表</title>
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
<title>新闻查看</title>

<style>
#wrapper {
	border: 3px solid #12C3EC;
}

#topstory img {
	/*width:99.5%;*/
	
}

#newsTitle {
	height: 40px;
	line-height: 20px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<!-- HEADER -->
		<div id="header" style="background-color: #21A4C2">
			<h3 id="logo" style="text-align: center">
				<font color="yellow" id="newsTypeTitle">新闻查看</font>
			</h3>
		</div>
		<div class="dataRange">
			<form name="queryForm" id="queryForm" method="post"
				action="worksList.htm">
				<div class="check-factor-1 emng-flex">
					<ul class="emng-flex">
						<li>
							<input type="hidden" name="currentPage" id="currentPage"
								value="${newsQueryForm.currentPage}" />
							<input type="hidden" id="pageNum" name="pageNum"
								value="${newsQueryForm.pageNum}">
							<input type="hidden" id="newsType" name="newsType"
								value="${newsQueryForm.type}">
						</li>
					</ul>
				</div>
			</form>
		</div>

		<ul class="list box">
			<c:forEach items="${pageList.resultList}" var="item"
				varStatus="status">
				<li class="box" onclick="showContent('${item.url}',${item.id})">
					<div class="list-img ">
						<a>
							<img id="firstimg1" src="${item.thumbMediaId}" alt="">
						</a>
					</div>
					<div class="list-txt" id="newsTitle">
						<h3>
							<a id="new1">${item.title}</a>
							<br>
						</h3>
					</div>
					<div class="list-txt">
						<h3>
							<a id="new1"> </a>
							<br>
						</h3>
					</div>
					<div class="list-txt">
						<h3>
							<a id="new1" style="color: #33AECC;">
								浏览次数(${item.viewCount})
								<br>
							</a>
						</h3>
					</div>
					<div class="text-overflow">
						<h3>
							<a id="new1">${item.digest}</a>
						</h3>
					</div>
				</li>
			</c:forEach>
			<c:choose>
				<c:when
					test="${newsQueryForm.currentPage==newsQueryForm.pageNum||newsQueryForm.pageNum==0}">
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
	var newsType = $('#newsType').val();

	$('#loadingMore').on('click', function() {
		$(this).html('正在加载...');
		getList();
	});

	function getList() {
		currentPage++;

		if (pageNum < currentPage) {
			// 			alert("0000");
			$('#loadingMore').html('没有更多数据了...');
			$('#loadingMore').off('click');
			return;
		}
		$
				.ajax({
					type : "get",
					url : 'newsQuery.json' + '?' + 'type=' + newsType
							+ '&currentPage=' + currentPage,
					async : true,
					success : function(data) {
						if (data.newsQueryAjaxResponse.list == null) {
							$('#loadingMore').html('没有更多数据了...');
							$('#loadingMore').off('click');
							return;
						} else {
							var Len = data.newsQueryAjaxResponse.list.length;
							if (Len < 2) {
								$('#loadingMore').html('没有更多数据了...');
								$('#loadingMore').off('click');
							} else {
								$('#loadingMore').html('点击加载更多...');
							}
							var oLi = '';
							for (var i = 0; i < Len; i++) {
								var id = data.newsQueryAjaxResponse.list[i].id;
								var url = data.newsQueryAjaxResponse.list[i].url;
								var title = data.newsQueryAjaxResponse.list[i].title;
								var digest = data.newsQueryAjaxResponse.list[i].digest;
								var thumbMediaId = data.newsQueryAjaxResponse.list[i].thumbMediaId;
								var viewCount = data.newsQueryAjaxResponse.list[i].viewCount;

								oLi += '<li class="box" onclick="showContent(&apos;'
										+ url
										+ '&apos;,'+id+')"><div class="list-img "><a>'
										+ ' <img id="firstimg1" src="'+
	thumbMediaId+'" alt=""></a></div><div class="list-txt"><h3>'
										+ '<a id="new1" id="newsTitle">'
										+ title
										+ '</a><br></h3></div><div class="list-txt"><h3><a id="new1"><br>'
										+ '</a></h3></div><div class="text-overflow"><h3><a id="new1">'
										+ '<div class="list-txt"><h3><a id="new1" style="color: #33AECC;">浏览次数('
										+ viewCount
										+ ')<br></a><br></h3></div>'
										+ digest
										+ '</a>'
										+ '</h3></div><br> </li>';

							}
							$(oLi).insertBefore($('#loadingMore'));
						}
					}
				});
	};

	function showContent(url,id) {
		// 		alert(id);
		location.href = url;//location.href实现客户端页面的跳转  
		//实现浏览量增1
		$
        .ajax({
            type : "get",
            url : 'addViewCount.json' + '?'+ 'id=' + id,
            async : true,
            success : function(data) {
                return;
            }
        });
	};

	window.onload = function() {

		if (newsType == 'xyxw') {
			$('#newsTypeTitle').html('学院新闻');
			$("title").html("学院新闻");
		}
		if (newsType == 'tzgg') {
			$('#newsTypeTitle').html('通知公告');
			$("title").html("通知公告");
		}
		if (newsType == 'xgdt') {
			$('#newsTypeTitle').html('学工动态');
			$("title").html("学工动态");
		}
		if (newsType == 'jwxx') {
			$('#newsTypeTitle').html('教务信息');
			$("title").html("教务信息");
		}
	};
</script>
</html>