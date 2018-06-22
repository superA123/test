<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>系统信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#mobile").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">系统信息</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="map" action="${ctx}/sys/register/save" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">版本号：</label>
			<div class="controls">
				<label class="lbl"> ${map.version} </label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户号：</label>
			<div class="controls">
				<label class="lbl"> <fmt:parseNumber value="${map.clientNo}" />
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">试用日期：</label>
			<div class="controls">
				<label class="lbl"> <fmt:formatDate value="${map.createDate}" type="both" dateStyle="full" />
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">到期日期：</label>
			<div class="controls">
				<label class="lbl"> <fmt:formatDate value="${map.updateDate}" type="both" dateStyle="full" />
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<input name="mobile" maxlength="11" value="${map.mobile}" class="required mobile"/>
				<span class="help-inline"><font color="red">*</font>仅作为联络注册事项使用</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册邮箱：</label>
			<div class="controls">
				<input name="registerMail" maxlength="20" value="${map.registerMail}" class="required email"/>
				<span class="help-inline"><font color="red">*</font>仅作为接收注册信息使用</span>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="注册"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<i class="icon-envelope"></i>
			<span class="help-inline"><a href="https://team.oschina.net/DreamerStudio" target="_blank">如有任何疑问，请联系我们</a></span>
		</div>
	</form:form>
</body>
</html>