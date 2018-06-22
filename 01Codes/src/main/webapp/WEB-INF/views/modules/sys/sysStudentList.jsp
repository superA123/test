<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生管理</title>
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
		<li class="active"><a href="#">学生列表</a></li>
		<shiro:hasPermission name="sys:sysStudent:edit"><li><a href="${ctx}/sys/sysStudent/form">学生添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysStudent" action="${ctx}/sys/sysStudent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生学号：</label>
				<form:input path="code" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>学号</th>
				<th>学生姓名</th>
				<th>所在班级</th>
				<th>性别</th>
				<th>年龄</th>
				<th>家长姓名</th>
				<th>联系方式</th>
				<th>家庭住址</th>
				<th>入学时间</th>
				<shiro:hasPermission name="sys:sysStudent:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysStudent">
			<tr>
				<td>${sysStudent.code}</td>
				<td><a href="${ctx}/sys/sysStudent/form?id=${sysStudent.id}">
					${sysStudent.name}
				</a></td>
				<td>${sysStudent.className}</td>
				<td>${sysStudent.gender}</td>
				<td>${sysStudent.age}</td>
				<td>${sysStudent.parentName}</td>
				<td>${sysStudent.phone}</td>
				<td>${sysStudent.address}</td>
				<td><fmt:formatDate value="${sysStudent.addtime}" pattern="yyyy-MM-dd" ></fmt:formatDate></td>
				<shiro:hasPermission name="sys:sysStudent:edit"><td>
    				<a href="${ctx}/sys/sysStudent/form?id=${sysStudent.id}">修改</a>
					<a href="${ctx}/sys/sysStudent/delete?id=${sysStudent.id}" onclick="return confirmx('确认要删除该学生吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>