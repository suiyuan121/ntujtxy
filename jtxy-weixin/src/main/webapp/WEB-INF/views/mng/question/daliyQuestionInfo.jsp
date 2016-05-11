<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="cn.edu.ntu.jtxy.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="keywords" content="交通学院微信管理平台" />
<meta name="description" content="连接你我" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/emng-1.0.0.css" />
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css"
	href="css/theme-origin/emng-origin.css" />
<link rel="stylesheet" type="text/css"
	href="css/theme-origin/public-origin.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/myPage.css" />
<title>每日一题管理</title>
<style type="text/css">
nav em {
	background-position: -180px 0;
}

.check-factor-wrapper .check-factor-2 .line-two .dk-2 li:nth-of-type(1)
	{
	margin-left: 25px;
}

.check-factor-wrapper .check-factor-2 .line-two .dk-2 li .emng-select {
	margin-left: 10px;
}

.check-factor-wrapper .check-factor-2 li input[type=text] {
	width: 100px;
}

#uid,#phoneNo {
	width: 200px;
}

@media ( min-width : 1500px) {
	.check-factor-wrapper .check-factor-2 li input[type=text] {
		width: 200px;
	}
	#uid,#phoneNo {
		width: 350px;
	}
}

.emng-select select,.emng-select {
	width: 200px;
}

.emng-select .emng-curselect {
	width: 168px;
}
</style>
</head>
<body>
	<nav class="emng-flex"> <em></em>
	<p>
		每日一题管理 ->
		<span>题目信息</span>
	</p>
	</nav>
	<div class="check-factor-wrapper">
		<article>查找</article>
		<form name="queryForm" id="queryForm" method="post"
			action="daliyQuestionInfo.htm">
			<div class="check-factor-1 emng-flex">
				<ul class="emng-flex">
					<li>
						<input type="hidden" name="currentPage" id="currentPage"
							value="${questionForm.currentPage}" />
					</li>
					<li>
						<span>内容:</span>
						<input type="text" name="content" class="Trim" id=content
							value="${questionForm.content}" />
					</li>
					<li>
						<span>类型:</span>
						<a class="emng-select">
							<strong class="emng-curselect"></strong>
							<select onchange="change($(this))" name="type" class="loc">
								<option value="common"
									${(questionForm.type eq 'common')?"selected='selected'":''}>普通</option>
								<option value="education"
									${(questionForm.type eq 'education')?"selected='selected'":''}>教育</option>
								<option value="medical"
									${(questionForm.type eq 'medical')?"selected='selected'":''}>医疗</option>
							</select>
						</a>
					</li>
					<li>
						<span>状态:</span>
						<a class="emng-select">
							<strong class="emng-curselect"></strong>
							<select onchange="change($(this))" name="status" class="loc">
								<option value="E"
									${(questionForm.status eq 'E')?"selected='selected'":''}>可用</option>
								<option value="D"
									${(questionForm.status eq 'D')?"selected='selected'":''}>不可用</option>
								<option value="S"
									${(questionForm.status eq 'S')?"selected='selected'":''}>已发送</option>
							</select>
						</a>
					</li>
					<li>
						<span>分值:</span>
						<a class="emng-select">
							<strong class="emng-curselect"></strong>
							<select onchange="change($(this))" name="value" class="loc">
								<option value="1"
									${(questionForm.value eq 1)?"selected='selected'":''}>1分</option>
								<option value="2"
									${(questionForm.value eq 2)?"selected='selected'":''}>2分</option>
								<option value="3"
									${(questionForm.value eq 3)?"selected='selected'":''}>3分</option>
								<option value="4"
									${(questionForm.value eq 4)?"selected='selected'":''}>4分</option>
								<option value="5"
									${(questionForm.value eq 5)?"selected='selected'":''}>5分</option>
							</select>
						</a>
					</li>
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
			<a href="daliyQuestionAdd.htm" id="user-buttonNew"
				class="emng-btn btn-bg-gray">新建</a>
		</div>
		<div>
			<ul class="pagination" id="pagination">
			</ul>
			<input type="hidden" id="totalCount" value="${pageList.totalCount}" />
			<input type="hidden" id="pageSize" value="${pageList.pageSize}" />
			<input type="hidden" id="pageNum" value="${pageList.pageNum}" />
		</div>
	</div>
	<div class="tab-wrapper">
		<table class="emng-table">
			<thead>
				<tr>
					<th>类型</th>
					<th>分值</th>
					<th>内容</th>
					<th>答案</th>
					<th>错误答案1</th>
					<th>错误答案2</th>
					<th>错误答案3</th>
					<th>状态</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.resultList}" var="item">
					<tr>
						<c:if test="${item.type eq 'common'}">
							<td>普通</td>
						</c:if>
						<c:if test="${item.type eq 'education'}">
							<td>教育</td>
						</c:if>
						<c:if test="${item.type eq 'medical'}">
							<td>医疗</td>
						</c:if>
						<td>${item.pointValue}</td>
						<td>${item.content}</td>
						<td>${item.answerCorrect}</td>
						<td>${item.answerOne}</td>
						<td>${item.answerTwo}</td>
						<td>${item.answerThree}</td>
						<td>${item.status}</td>
						<td>
							<a href="daliyQuestionUpdate.htm?id=${item.id}"
								class="emng-editbtn"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script src="js/plugin/jquery-2.1.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/noty.js" type="text/javascript" charset="utf-8"></script>
<script src="js/plugin/select-changes.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/vertifycate.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/plugin/Widget.js" type="text/javascript" charset="utf-8"></script>
<script src="js/plugin/Window.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/pagination.js" type="text/javascript"></script>
<script src="js/main/org-infoEdit.js" type="text/javascript"
	charset="utf-8"></script>


<script type="text/javascript">
	$(document).ready(showPageLabel("queryForm", "$pageList"));
</script>
</html>
