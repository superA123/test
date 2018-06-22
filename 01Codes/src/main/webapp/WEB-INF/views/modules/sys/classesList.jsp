<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>班级管理</title>
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
		<li class="active"><a href="#">班级列表</a></li>
		<shiro:hasPermission name="sys:classes:edit"><li><a href="${ctx}/sys/classes/form">班级添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="classes" action="${ctx}/sys/classes/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>班级类型：</label><form:select id="type" path="type" class="input-medium"><form:option value="" label=""/>
		<form:options  items="${fns:getDictList('sys_class_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/></form:select>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
		
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>班级编号</th>
				<th>班级名称</th>
				<th>班级类型</th>
				<th>班主任</th>
				<shiro:hasPermission name="sys:classes:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="classes">
			<tr>
				<td>${classes.code}</td>
				<td><a href="${ctx}/sys/classes/form?id=${classes.id}">
					${classes.classname}
				</a></td>
				<td>${fns:getDictLabel(classes.type, 'sys_class_type', '无状态')}</td>
				<td>${classes.userName}</td>
				<shiro:hasPermission name="sys:classes:edit"><td>
    				<a href="${ctx}/sys/classes/form?id=${classes.id}">修改</a>
					<a href="${ctx}/sys/classes/delete?id=${classes.id}" onclick="return confirmx('确认要删除该班级吗？', this.href)">删除</a>
					<a href="${ctx}/sys/sysStudent/list?classid=${classes.code}">查看该班级下所有学生信息</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>