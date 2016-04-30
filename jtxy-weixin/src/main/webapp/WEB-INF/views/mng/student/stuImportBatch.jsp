<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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

<!--theme-->
<link rel="stylesheet" type="text/css" href="css/theme-origin/emng-origin.css" />
<link rel="stylesheet" type="text/css" href="css/theme-origin/menu-list-origin.css" />
<title>学生管理批量注册</title>
<style type="text/css">
nav em {
	background-position: -180px 0;
}

#file-trigger {
	display: none;
}

.tab li {
	margin-bottom: 35px;
}

#filepath {
	display: inline-block;
	margin-left: 20px;
	border: none;
	width: 400px;
	overflow: hidden;
	font-family: "microsoft yahei";
}

#nofile {
	left: 205px;
	top: 8px;
}

.tab li:nth-last-of-type(3) label,.tab li:nth-last-of-type(4) label {
	margin-right: 50px;
}

.emng-select,.emng-select .loc,.emng-select .emng-curselect {
	width: 228px;
}

@media ( min-width : 1000px) and (max-width: 1499px) {
	.emng-select .loc,.emng-select {
		width: 261px;
	}
	.emng-select .emng-curselect {
		width: 226px;
	}
}

@media ( min-width : 1500px) and (max-width:1600px) {
	.emng-select .loc,.emng-select {
		width: 327px;
	}
	.emng-select .emng-curselect {
		width: 292px;
	}
}

@media ( min-width : 1620px) and (max-width:1800px) {
	.emng-select .loc,.emng-select {
		width: 427px;
	}
	.emng-select .emng-curselect {
		width: 392px;
	}
}
</style>
</head>
<body>
	<nav class="emng-flex">
		<em></em>
		<p>
			学生管理
			<span>->批量注册</span>
		</p>
	</nav>
	<div class="btn-area emng-flex">
		<button class="emng-btn btn-bg-blue" id="go-back" onclick="window.location.href='stuInfo.htm'">返回</button>
		<button class="emng-btn btn-bg-blue" id="go-submit" type="button">导入</button>
	</div>
	<div class="tab">
		<form name="" method="post" action="stuImportBatch.htm" id="formRegister" enctype="multipart/form-data">
			<input type="hidden" name="msg" id="msg" value="$!{msg}" />
			<ul>
				<li>
					<span>
						<i class="must">*</i>
						批次名称:
					</span>
					<input type="text" id="user-batchname" name="batchName" value="$!{addForm.batchName}" maxlength="20" placeholder="20个字之内    请勿输入空格等特殊字符" />
					<label class="error"></label>
				</li>
				<li>
					<span></span>
					<button class="emng-btn btn-bg-blue" id="select-file" type="button">选择文件</button>
					<input type="file" id="file-trigger" name="excelFile" value="" />
					<input type="text" id="filepath" value="" />
					<label class="error" id="nofile"></label>
				</li>
				<li>
					<span></span>
					<a href="${link.contextPath}/download/importUser.xls" class="a-btn">下载模板</a>
				</li>
				#if(${errorId})
				<li>
					<span></span>
					<a href="${link.contextPath}/downloadErrorFile.htm?errorId=$!{errorId}" style="color: red;">下载查看错误反馈信息</a>
				</li>
				#end
			</ul>
		</form>
	</div>
</body>
<script src="${link.contextPath}/js/plugin/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
<script src="${link.contextPath}/js/plugin/vertifycate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${link.contextPath}/js/plugin/noty.js" type="text/javascript" charset="utf-8"></script>
<script src="${link.contextPath}/js/plugin/select-changes.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(document).ready(function() {
        notyMsg();

        change($('#loc_default'));
        $('.loc').each(function(i, e) {
            change($(e));
        });
        //表单验证
        $('#go-submit').click(function() {
            if (!$('#orgId').validator({
                errContainer : $('#noOrg'),
                equalStr : '-1',
                equalStrMsg : '请选择组织'
            }) || !$('#user-batchname').validator({
                errorTips : '请勿输入特殊字符',
                required : true,
                requiredMsg : '批次名称不能为空',
                testType : 'sPecial'
            }) || !$('#filepath').validator({
                errContainer : $('#nofile'),
                required : true,
                requiredMsg : '请选择文件'
            })) {
                return false;
            } else {
                $('#go-back').attr('disabled', true);
                $('#formRegister').submit();
            }
        });

        $('#select-file').click(function() {
            $('#file-trigger').trigger('click');
        });

        function fileCheck() {
            var type, size;
            type = this.files[0].type;
            size = this.files[0].size / 1024;
            if (type.indexOf('excel') == -1 && type.indexOf('sheet') == -1) {
                noty({
                    'text' : '只能上传xls或者xlsx格式的文件'
                });
                this.value = '';
            } else if (size > 512) {
                noty({
                    'text' : '上传的文件大小不能超过0.5M'
                });
                this.value = '';
            } else {
                var path = this.value;
                //javascript无法获取文件位于系统的位置,只能显示文件名
                path = path.substring(path.lastIndexOf("\\") + 1, path.length);
                $('#nofile').html('');
                $('#filepath').val(path);
            }
        }
        ;

        $('#file-trigger')[0].onchange = fileCheck;
    });

    function notyMsg() {
        var msg = $('#msg').val();
        if (msg != "") {
            options = {
                'text' : msg,
                'layout' : 'top'
            };
            noty(options);
        }
    }
</script>
</html>
