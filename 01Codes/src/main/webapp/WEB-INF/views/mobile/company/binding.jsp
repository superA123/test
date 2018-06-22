<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/mobile/include/taglib.jsp"%>
<html>
<head>
<%-- <spring:message code="common.page.title"/> --%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<%@ include file="/WEB-INF/views/mobile/include/head.jsp"%>
<script type="text/javascript">
	//已发送的验证码
	var sentCode = "";
	var isCheck = 0;

	$(document).ready(function() {
		$("#email").focus();
		$("#msgDiv").hide();
		$("#icon_success").hide();
		$("#icon_warn").hide();
		
		$("#code").change(function() {
			var code = $("#code").val();
			if (sentCode != "" && sentCode == code) {
				$("#icon_success").show();
				$("#icon_warn").hide();
				isCheck = 1;
			} else {
				$("#icon_warn").show();
				$("#icon_success").hide();
				isCheck = 0;
			}
		});
	});

	function save() {
		var email = $("#email").val();
		if ($.trim(email) == "") {
			$.toptip('邮箱前缀不能为空！');
			return false;
		}
		var code = $("#code").val();
		if ($.trim(code) == "") {
			$.toptip('验证码不能为空！');
			return false;
		} else if (isCheck === 0) {
			$.toptip('验证码错误！');
			return false;
		} else {
			$.post(ctx + "/company/binding/binding", $("#inputForm").serialize(),
				function(data) {
					if (data.result == "true") {
						$("#codeDiv").hide();
						$("#msgDiv").show();
					} else {
						$.toast("身份验证失败");
					}
				}, "json");
		}
	}

	function sendMail(val) {
		var email = $("#email").val();
		if ($.trim(email) == "") {
			$.toptip('邮箱前缀不能为空！');
			return false;
		}

		$.post(ctx + "/company/binding/sendMail", $("#inputForm").serialize(),
				function(data) {
					if (data.result == "true") {
						sentCode = data.code;
						$.toptip('验证码已发送到您的邮箱！', 'success');
						settime(val);
					} else {
						$.toptip('验证码发送失败！');
					}
				}, "json");
	}

	var countdown = 60;
	function settime(val) {
		if (countdown == 0) {
			val.removeAttribute("disabled");
			val.value = "获取验证码";
			countdown = 60;
			return;
		} else {
			val.setAttribute("disabled", true);
			val.value = "重新发送(" + countdown + ")";
			countdown--;
		}
		setTimeout(function() {
			settime(val)
		}, 1000)
	}
</script>
</head>

<body ontouchstart>
<form:form id="inputForm" modelAttribute="emloyee" action="${ctx}/company/binding" method="post">
	<form:hidden path="weUserId"/>
		<div id="codeDiv">
			<div class="weui_cells weui_cells_form">
				<div class="weui_cells_title">通过企业邮箱账号验证身份完成关注</div>
				<div class="weui_cell">
					<div class="weui_cell_hd">
						<label class="weui_label_short">邮箱前缀</label>
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_bd weui_cell_primary" style="display: inline-block">
						<form:input path="email" htmlEscape="false" maxlength="15" class="weui_input" cssStyle="width:50%" placeholder="填写邮箱前缀" />
						<label class="">${fns:getConfig("mail.suffix")}</label>
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_hd">
						<label class="weui_label_short">验证码</label>
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_bd weui_cell_primary" style="display: inline-block">
						<form:input id="code" path="code" htmlEscape="false" maxlength="4" class="weui_input" cssStyle="width:50%" placeholder="填写验证码" />
						<input type="button" id="btn" class="weui_btn weui_btn_mini weui_btn_default" style="width: 100px; padding-top: 5px; padding-bottom: 5px;" value="获取验证码" onclick="sendMail(this)" />
						<i id="icon_success" class="weui_icon_success"></i>
						<i id="icon_warn" class="weui_icon_warn"></i>
					</div>
				</div>
			</div>
			<div class="weui_btn_area">
				<input type="button" class="weui_btn weui_btn_primary" value="验证" onclick="save();">
			</div>
			<div class="weui_cells_title" style="text-align: center">本页面转发无效</div>
		</div>
		<div id="msgDiv" class="weui_msg">
			<div class="weui_icon_area">
				<i class="weui_icon_success weui_icon_msg"></i>
			</div>
			<div class="weui_text_area">
				<h2 class="weui_msg_title">操作成功</h2>
				<p class="weui_msg_desc">身份验证通过欢迎使用</p>
			</div>
		</div>
	</form:form>
</body>
</html>
