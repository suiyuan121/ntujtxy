<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="cn.edu.ntu.jtxy.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>积分排行榜</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript">
	document.getElementsByTagName('html')[0].style.fontSize = document.documentElement.clientWidth
			+ 'px';
</script>
<link rel="stylesheet" type="text/css" href="css/dataList.css" />
</head>
<body>
	<div class="dataRange">
		<form action="pointSort.htm" method="post">
			<input type="hidden" id="currentPage" name="currentPage"
				value="${pointPageQueryForm.currentPage}">
			<input type="hidden" id="pageNum" name="pageNum"
				value="${pointPageQueryForm.pageNum}">
			<ul>
				<li>
					<span>学号</span>
					<input type="text" name="stuNo" id="stuNo"
						value="${pointPageQueryForm.stuNo}" />
				</li>
				<li>
					<span>姓名</span>
					<input type="text" name="stuName" id="stuName"
						value="${pointPageQueryForm.stuName}" />
					<button type="submit" id="searchData">查 询</button>
				</li>
			</ul>
		</form>
	</div>
	<div class="dataDetail">
		<ul>
			<c:forEach items="${pageList.resultList}" var="item">
				<li>
					<span class="health-data">
						学号：
						<b class="fatRate">${item.stuNo}</b>
					</span>
					<span class="health-data">
						积分：
						<b class="fatRate">${item.pointAmout}</b>
					</span>
					<strong class="health-status"></strong>
				</li>
			</c:forEach>
		</ul>
		<c:choose>
			<c:when test="${pageList.totalCount == 0}">
				<p id="noRecord">没有记录...</p>
			</c:when>
			<c:otherwise>
				<div id="loadingMore">点击加载更多...</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="window-mask"></div>
	<div id="window-alert">
		<p></p>
		<ul>
			<li>
				<button type="button" id="btn-confirm">确 认</button>
			</li>
		</ul>
	</div>
</body>
<script src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	var stuNo = $('#stuNo').val();
	var stuName = $('#stuName').val();
	var currentPage = $('#currentPage').val();
	var pageNum = $('#pageNum').val();

	if ($('.fatRate').length < 2) {
		$('#loadingMore').hide();
	}

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
					url : 'pointQuery.json' + '?stuNo=' + stuNo
							+ '&currentPage=' + currentPage + '&stuName='
							+ stuName,
					async : true,
					success : function(data) {
						if (data.pointQueryAjaxResponse.list == null) {
							$('#loadingMore').html('没有更多数据了...');
							$('#loadingMore').off('click');
							return;
						} else {
							var Len = data.pointQueryAjaxResponse.list.length;
							if (Len < 2) {
								$('#loadingMore').html('没有更多数据了...');
								$('#loadingMore').off('click');
							} else {
								$('#loadingMore').html('点击加载更多...');
							}
							var oLi = '';
							for (var i = 0; i < Len; i++) {
								var stuNo = data.pointQueryAjaxResponse.list[i].stuNo;
								var realName = data.pointQueryAjaxResponse.list[i].pointAmout;
								oLi += '<li><span class="health-data">'
										+ '<b class="fatRate">'
										+ stuNo
										+ '</b></span><span class="health-data">积分：<b class="fatRate">'
										+ realName
										+ '</b></span><strong class="health-status"></strong></li>';
							}
							$(oLi).insertBefore($('#loadingMore'));
						}
					}
				});
	};
</script>
</html>
