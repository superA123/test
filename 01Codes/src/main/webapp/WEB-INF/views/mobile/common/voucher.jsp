<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<%-- <spring:message code="common.page.title" /> --%>
	<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	$(function(){  
	    pushHistory();  
	    window.addEventListener("popstate", function(e) {  
	        WeixinJSBridge.call('closeWindow');
	}, false);  
	    function pushHistory() {  
	        var state = {  
	            title: "title",  
	            url: "#"  
	        };  
	        window.history.pushState(state, "title", "#");  
	    }  
	});  
	</script>
</head>

<body ontouchstart>
	<form:form id="voucherForm" modelAttribute="voucherDto">
		<div class="weui_msg">
			<div class="weui_icon_area">
				<c:choose>
					<c:when test="${empty voucherDto}">
						<i class="weui_icon_msg weui_icon_warn"></i>
					</c:when>
					<c:otherwise>
						<i class="weui_icon_msg ${voucherDto.iconClass}"></i>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="weui_text_area">
				<c:choose>
					<c:when test="${empty voucherDto}">
						<h2 class="weui_msg_title"><spring:message code="wechat.service.page.exception.msgTitle" /></h2>
						<p class="weui_msg_desc"><spring:message code="wechat.service.page.exception.msgDesc" /></p>
					</c:when>
					<c:otherwise>
						<h2 class="weui_msg_title">${voucherDto.msgTitle}</h2>
						<p class="weui_msg_desc">${voucherDto.msgDesc}</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="weui_opr_area">
				<p class="weui_btn_area"></p>
			</div>
		</div>
	</form:form>
</body>
</html>
