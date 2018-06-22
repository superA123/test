<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招生管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">招生列表</a></li>
<%-- 		<shiro:hasPermission name="cms:student:edit"><li><a href="${ctx}/cms/student/form">招生添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="student" action="${ctx}/cms/student/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>家长姓名</th>
				<th>学生姓名</th>
				<th>联系电话</th>
				<th>联系邮箱</th>
				<th>家庭住址</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="student">
			<tr>
				<td>${student.name}</td>
				<td>${student.stuname}</td>
				<td>${student.phone}</td>
				<td>${student.email}</td>
				<td>${student.address}</td>
				<td>${fns:getDictLabel(student.reContent, 'cms_student_statu', '未审核')}</td>
				<shiro:hasPermission name="cms:guestbook:edit"><td>
					<a href="${ctx}/cms/student/form?id=${student.id}">审核</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot/>
		<p>如同意该生入学请与家长联系</p>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>