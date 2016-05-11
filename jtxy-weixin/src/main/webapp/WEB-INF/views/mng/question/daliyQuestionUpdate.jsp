<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="keywords" content="交通学院微信管理平台" />
<meta name="description" content="连接你我" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/emng-1.0.0.css" />
<link rel="stylesheet" type="text/css" href="css/public.css" />

<!--theme-->
<link rel="stylesheet" type="text/css"
	href="css/theme-origin/emng-origin.css" />
<link rel="stylesheet" type="text/css"
	href="css/theme-origin/public-origin.css" />
<title>新建每日一题信息</title>
<style type="text/css">
nav em {
	background-position: -60px 0;
}

#genderA,#gender {
	width: 692px;
}

.emng-select,.emng-select select {
	width: 200px;
}

.emng-select .emng-curselect {
	width: 195px;
}

@media ( min-width : 1000px) and (max-width: 1499px) {
	#genderA,#gender {
		width: 789px;
	}
	.emng-select .emng-curselect {
		width: 228px;
	}
}

@media ( min-width : 1500px) and (max-width:1600px) {
	#genderA {
		width: 989px;
	}
	.emng-select,.emng-select select {
		width: 329px;
	}
	.emng-select .emng-curselect {
		width: 294px;
	}
}

@media ( min-width : 1620px) and (max-width:1800px) {
	#genderA {
		width: 1289px;
	}
	.emng-select,.emng-select select {
		width: 429px;
	}
	.emng-select .emng-curselect {
		width: 394px;
	}
}
</style>
</head>
<body>
	<nav class="emng-flex">
		<em></em>
		<p>
			每日一题管理
			<span>->更新每日一题</span>
		</p>
	</nav>
	<div class="btn-area emng-flex">
		<a href="daliyQuestionInfo.htm" class="emng-btn btn-bg-blue"
			id="go-back">返回</a>
		<button class="emng-btn btn-bg-blue" id="go-submit" type="button">提交</button>
	</div>
	<div class="tab">
		<form name="updateQuestionForm" id="updateQuestionForm" method="post"
			action="daliyQuestionUpdate.htm">
			<input type="hidden" value="${questionUpdateForm.id}" name="id">
			<ul>
				<li>
					<span>
						<i class="must">*</i>
						类型:
					</span>
					<a class="emng-select" id="type">
						<strong class="emng-curselect"></strong>
						<select onchange="change($(this))" name="type" class="loc"
							id="type" r>
							<option value="common"
								${(questionUpdateForm.type eq 'common')?"selected='selected'":''}>普通</option>
							<option value="education"
								${(questionUpdateForm.type eq 'education')?"selected='selected'":''}>教育</option>
							<option value="medical"
								${(questionUpdateForm.type eq 'medical')?"selected='selected'":''}>医疗</option>
						</select>
					</a>
					<label class="error" id="typeError"></label>
				</li>
				<li>
					<span>
						<i class="must">*</i>
						分值:
					</span>
					<a class="emng-select" id="pointValue">
						<strong class="emng-curselect"></strong>
						<select onchange="change($(this))" name="pointValue" class="loc"
							id="pointValue">
							<option value="1"
								${(questionUpdateForm.pointValue eq 1)?"selected='selected'":''}>1分</option>
							<option value="2"
								${(questionUpdateForm.pointValue eq 2)?"selected='selected'":''}>2分</option>
							<option value="3"
								${(questionUpdateForm.pointValue eq 3)?"selected='selected'":''}>3分</option>
							<option value="4"
								${(questionUpdateForm.pointValue eq 4)?"selected='selected'":''}>4分</option>
							<option value="5"
								${(questionUpdateForm.pointValue eq 5)?"selected='selected'":''}>5分</option>
						</select>
					</a>
					<label class="error" id="valueError"></label>
				</li>

				<li>
					<span>
						<i class="must">*</i>
						题目内容:
					</span>
                    <textarea rows="5" cols="120" id="content" name="content"> ${questionUpdateForm.content} </textarea>
					<label class="error"></label>
				</li>
				<li>
					<span>
						<i class="must">*</i>
						正确答案:
					</span>
					<textarea rows="2" cols="120" id="answerCorrect" name="answerCorrect">${questionUpdateForm.answerCorrect}</textarea>
					<label class="error"></label>
				</li>
				<li>
					<span>
						<i class="must">*</i>
						错误答案1:
					</span>
					<textarea rows="2" cols="120" id="answerOne" name="answerOne">${questionUpdateForm.answerOne}</textarea>
					<label class="error"></label>
				</li>
				<li>
					<span>
						<i class="must">*</i>
						错误答案2:
					</span>
					<textarea rows="2" cols="120" id="answerTwo" name="answerTwo">${questionUpdateForm.answerTwo}</textarea>
					<label class="error"></label>
				</li>
				<li>
					<span>
						<i class="must">*</i>
						错误答案3:
					</span>
					<textarea rows="2" cols="120" id="answerThree" name="answerThree">${questionUpdateForm.answerThree}</textarea>
					<label class="error"></label>
				</li>
			</ul>
			<label id="submitReturn" style="display: none;">${msg}</label>
		</form>
	</div>
	<script src="js/plugin/jquery-2.1.0.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/plugin/vertifycate.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/plugin/select-changes.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="js/plugin/noty.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/main/org-infoEdit.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//表单验证
			(function() {
				$('#go-submit').click(function() {

					var content = $('#content').val();
					alert("text5559" + content);
					
					if (!$('#content').validator({
						required : true,
						requiredMsg : '题目内容不能为空'
					}) || !$('#answerCorrect').validator({
						required : true,
						requiredMsg : '正确答案不能为空'
					}) || !$('#answerOne').validator({
						required : true,
						requiredMsg : '错误答案1不能为空'
					}) || !$('#answerTwo').validator({
						required : true,
						requiredMsg : '错误答2不能为空',
					}) || !$('#answerThree').validator({
						required : true,
						requiredMsg : '错误答3不能为空'
					})) {
						return false;
					} else {
						if ($('#type').find('option').length <= 1) {
							$('#typeError').html("请选择类别!");
							return false;
						}
						if ($('#pointValue').find('option').length <= 1) {
							$('#valueError').html("请选择分值!");
							return false;
						}
						$('#updateQuestionForm').submit();
					}
				});

				$('#content').blur(function() {
					$(this).validator({
						required : true,
						requiredMsg : '题目内容不能为空'
					});
				});
				$('#answerCorrect').blur(function() {
					$(this).validator({
						required : true,
						requiredMsg : '正确答案不能为空'
					});
				});
				$('#answerOne').blur(function() {
					$(this).validator({
						required : true,
						requiredMsg : '错误答案1不能为空'
					});
				});
				$('#answerTwo').blur(function() {
					$(this).validator({
						required : true,
						requiredMsg : '错误答案2不能为空'
					});
				});
				$('#answerThree').blur(function() {
					$(this).validator({
						required : true,
						requiredMsg : '错误答案3不能为空'
					});
				});

				if ($('#type').find('option').length < 1) {
					$('#typeError').html("请选择类别!");
					return;
				}
				if ($('#pointValue').find('option').length < 1) {
					$('#valueError').html("请选择分值!");
					return;
				}

				$('#updateQuestionForm').enterSub($('#go-submit'));
			})();

			//加载msg
			window.onload = function() {
				var Msg = $('#submitReturn').html();
				var options = '';
				if (Msg != '') {
					options = {
						"text" : Msg,
						"layout" : "top"
					};
					noty(options);
				}
			}
		});
	</script>
</body>
</html>
