<%
response.setStatus(500);

// 获取异常类
Throwable ex = Exceptions.getThrowable(request);
if (ex != null){
	LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
}

// 编译错误信息
StringBuilder sb = new StringBuilder("错误信息：\n");
if (ex != null) {
	sb.append(Exceptions.getStackTraceAsString(ex));
} else {
	sb.append("未知错误.\n\n");
}

// 如果是异步请求或是手机端，则直接返回信息
if (Servlets.isAjaxRequest(request)) {
	out.print(sb);
}

// 输出异常信息页面
else {
%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.cloud.jeesite.core.common.web.Servlets"%>
<%@page import="com.cloud.jeesite.core.common.utils.Exceptions"%>
<%@page import="com.cloud.jeesite.core.common.utils.StringUtils"%>
<%@page import="com.cloud.jeesite.core.common.beanvalidator.BeanValidators"%>
<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>500 - 系统内部错误</title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header"><h1>系统内部错误.</h1></div>
		<div class="errorMessage">
<%-- 			
			错误信息：<%=ex==null?"未知错误.":StringUtils.toHtml(ex.getMessage())%> <br/> <br/>
			请点击“查看详细信息”按钮，将详细错误信息发送给系统管理员，谢谢！<br/> <br/>
			<a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a> &nbsp;
			<a href="javascript:" onclick="$('.errorMessage').toggle();" class="btn">查看详细信息</a> 
--%>
			<p style="color:red;">错误信息：</p>
		<p>
		<%
			if (ex!=null){
				if (ex instanceof javax.validation.ConstraintViolationException){
					for (String s : BeanValidators.extractPropertyAndMessageAsList((javax.validation.ConstraintViolationException)ex, ": ")){
						out.print(s+"<br/>");
					}
				} else if (ex instanceof com.cloud.jeesite.core.common.service.ServiceException){
					String messageCode = "message.common."+ex.getMessage();
					request.setAttribute("messageCode", messageCode);
					out.print(ex.getMessage()+"：");
		%>
						<spring:message code='${messageCode}'/><br/>
		<%
				}else{
					out.print(ex+"<br/>");
				}
			}
		%>
		</p>
		</div>
		<div class="errorMessage hide">
			<%=StringUtils.toHtml(sb.toString())%> <br/>
			<a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a> &nbsp;
			<a href="javascript:" onclick="$('.errorMessage').toggle();" class="btn">隐藏详细信息</a>
			<br/> <br/>
		</div>
		<script>try{top.$.jBox.closeTip();}catch(e){}</script>
	</div>
</body>
</html>
<%
} out = pageContext.pushBody();
%>