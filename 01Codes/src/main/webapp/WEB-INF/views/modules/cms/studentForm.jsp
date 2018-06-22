<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招生管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#reContent").focus();
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
		<li><a href="${ctx}/cms/student/">招生列表</a></li>
		<li class="active"><a href="${ctx}/cms/student/form?id=${student.id}">招生审核</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="student" action="${ctx}/cms/student/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="reContent"/>
			<div class="control-group">
				<label class="control-label">家长姓名:</label>
				<div class="controls">
					<c:out value="${student.name}"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学生姓名:</label>
				<div class="controls">
					<c:out value="${student.stuname}"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">联系邮箱:</label>
				<div class="controls">
					<c:out value="${student.email}"/>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label">联系电话:</label>
				<div class="controls">
					<c:out value="${student.phone}"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">家庭住址:</label>
				<div class="controls">
					<c:out value="${student.address}"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">班级分类:</label>
				<div class="controls">
					<div class="controls">
						<span style="font-weight:bold;"><c:out value="${fns:getDictLabel(student.type, 'sys_class_type', '无')}"/></span>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学生简介:</label>
					<div class="controls">
						<form:textarea path="content" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge" disabled="true"/>
					</div>
			</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-success" type="submit" value="通 过" onclick="$('#reContent').val('2')"/>&nbsp;
			<input id="btnSubmit" class="btn btn-inverse" type="submit" value="驳 回" onclick="$('#reContent').val('1')"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>