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
			新闻推送 -> <span>推送新闻</span>
		</p>
	</nav>
	<div class="check-factor-wrapper">
		<article>选择群发人员</article>
		<form name="pushNewsForm" id="pushNewsForm" action="newsPush.htm"
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
					</a> <input type="hidden" name="mediaId" value="" id="mediaId">
						<input type="hidden" name="type" value="push" id="push"></li>
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
		<article>查找图文</article>
		<form name="queryNewsForm" id="queryNewsForm" method="post"
			action="newsPush.htm">
			<div class="check-factor-1 emng-flex">
				<ul class="emng-flex">
					<li><input type="hidden" name="currentPage" id="currentPage"
						value="${newsQueryForm.currentPage}" /></li>
					<li><span>title:</span> <input type="text" name="title"
						class="Trim" id="title" value="${newsQueryForm.title}" /></li>
				</ul>
				<div class="check-search-wrapper emng-flex">
					<button id="person-searchBtn" class="emng-btn btn-bg-blue"
						type="submit">查找</button>
				</div>
			</div>

		</form>
	</div>
	<div class="pagebtn-wrapper emng-flex">
		<div class="btn-wrap emng-flex">
			<a href="newsInfoAdd.htm" id="user-buttonNew"
				class="emng-btn btn-bg-gray-"></a>
		</div>
		<div>
			<ul class="pagination" id="pagination">
			</ul>
			<input type="hidden" id="totalCount" value="${pageList.totalCount}" />
			<input type="hidden" id="pageSize" value="${pageList.pageSize}" /> <input
				type="hidden" id="pageNum" value="${pageList.pageNum}" />
		</div>
	</div>
	<div class="tab-wrapper">
		<table class="emng-table">
			<thead>
				<tr>
					<th>选择</th>
					<th>编号</th>
					<th>标题</th>
					<th>摘要</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap}" var="item">
					<c:forEach items="${item.value}" var="item2" varStatus="status">
						<tr>
							<c:choose>
								<c:when test="${status.count==1}">
									<td><label class="emng-checkbox-wrap"> <input
											type="checkbox" class="emng-checkbox emng-checkbox-item"
											name="chkSon" id="pushCheckBox" value="${item.key}" /> <b></b>
									</label></td>
									<td>${item.key}</td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td></td>
								</c:otherwise>
							</c:choose>
							<td>${item2.title}</td>
							<td>${item2.digest}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script src="js/plugin/jquery-2.1.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/vertifycate.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/select-changes.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/Widget.js" type="text/javascript" charset="utf-8"></script>
<script src="js/plugin/Window.js" type="text/javascript" charset="utf-8"></script>
<script src="js/plugin/noty.js" type="text/javascript" charset="utf-8"></script>
<script src="js/main/org-infoEdit.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/pagination.js" type="text/javascript"></script>

<script type="text/javascript">
	$('#pushNews-button').click(function() {

		var checkItem = $('input[name=chkSon]').filter(':checked');
		var checkedLength = checkItem.length;
		var str = '';

		if (checkedLength == 0) {
			alert("请先选择要群发的图文!");
			return false;
		} else {

			if (confirm('您确定要群发吗')) {
				$("[name='chkSon'][checked]").each(function() {
					str += $(this).val();
				});
				$('#mediaId').val(str);
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

	$(function() {
		$(':checkbox[name=chkSon]').each(function() {
			$(this).click(function() {
				$(':checkbox[name=chkSon]').removeAttr('checked');
				$(this).attr('checked', 'true');
				$(this).prop("checked", true);
			});
		});
	});

	$(document).ready(

	showPageLabel("queryNewsForm", "$pageList")

	);
</script>
</html>
