<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>招生专栏</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="JeeSite ${site.description}" />
	<meta name="keywords" content="JeeSite ${site.keywords}" />
		<link href="" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/jquery/jquery-1.12.4.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-validation/1.13.1/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-validation/1.13.1/jquery.validate.method.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			<c:if test="${not empty message}">alert("${message}");</c:if>
			$("#inputForm").validate({
				rules: {
					validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
				},
				messages: {
					name: {required: "请填写家长姓名"},
					stuname: {required: "请填写学生姓名"},
					email: {required: "请填写联系邮箱"},
					phone: {required: "请填写联系电话"},
					address: {required: "请填写家庭住址"},
					content: {required: "请填写简单的学生介绍"},
					validateCode: {remote: "验证码不正确"}
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			$("#main_nav li").each(function(){
				$(this).toggleClass("active", $(this).text().indexOf('公共留言')>=0);
			});
		});
		function page(n,s){
			location="${ctx}/guestbook?pageNo="+n+"&pageSize="+s;;
		}
	</script>
</head>
<body>
	<div>
		<h4>招生简介</h4>
	<pre style="font-size:15px;font-family:幼圆;">
	2018年招生简章
			
		 我园新生招生工作即将开始，为了更好的完成此项工作，解决家长的后顾之忧，让适龄儿童都能享受幼稚的学前教育，
	 现开通网上报名。请家长如实填写一下相关信息，等待我园工作人员的联系。
		</pre>
		<h4>我要报名</h4>
		<form:form id="inputForm" action="${ctx}/student" method="post" class="form-horizontal">
			<div class="control-group">
				<label class="control-label">家长姓名:</label>
				<div class="controls">
					<input type="text" name="name" maxlength="11" class="required" style="width:300px;"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学生姓名:</label>
				<div class="controls">
					<input type="text" name="stuname" maxlength="50" class="required" style="width:300px;"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">联系邮箱:</label>
				<div class="controls">
					<input type="text" name="email" maxlength="50" class="required email" style="width:300px;"/>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label">联系电话:</label>
				<div class="controls">
					<input type="text" name="phone" maxlength="50" class="required phone" style="width:300px;"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">家庭住址:</label>
				<div class="controls">
					<input type="text" name="address" maxlength="50" class="required" style="width:300px;"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">班级分类:</label>
				<div class="controls">
					<select name="type" class="txt required" style="width:100px;">
						<option value="">请选择</option>
						<c:forEach items="${fns:getDictList('sys_class_type')}" var="type">
							<option value="${type.value}">${type.label}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学生简介:</label>
				<div class="controls">
					<textarea name="content" rows="4" maxlength="200" class="required" style="width:400px;"></textarea>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">验证码:</label>
				<div class="controls">
					<sys:validateCode name="validateCode" />
				</div>
			</div>
			<div class="form-actions">
				<input class="btn" type="submit" value="提 交"/>&nbsp;
			</div>
			<div id="messageBox" class="alert alert-error" style="display:none">输入有误，请先更正。</div>
		</form:form>
	</div>
</body>
</html>