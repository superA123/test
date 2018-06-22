<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>新闻管理</title>
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
		<li class="active"><a href="#">新闻列表</a></li>
		<shiro:hasPermission name="cms:cmsNews:edit"><li><a href="${ctx}/cms/cmsNews/form">新闻添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cmsNews" action="${ctx}/cms/cmsNews/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>内容</th>
				<th>添加时间</th>
				<shiro:hasPermission name="cms:cmsNews:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsNews">
			<tr>
				<td><a href="${ctx}/cms/cmsNews/form?id=${cmsNews.id}">
					${cmsNews.title}
				</a></td>
				<td><a href="${ctx}/cms/cmsNews/form?id=${cmsNews.id}">
					${cmsNews.content}
				</a></td>
				<td><a href="${ctx}/cms/cmsNews/form?id=${cmsNews.id}">
					<fmt:formatDate value="${cmsNews.addtime}" pattern="yyyy.MM.dd"/>
				</a></td>
				<shiro:hasPermission name="cms:cmsNews:edit"><td>
    				<a href="${ctx}/cms/cmsNews/form?id=${cmsNews.id}">修改</a>
					<a href="${ctx}/cms/cmsNews/delete?id=${cmsNews.id}" onclick="return confirmx('确认要删除该新闻吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>