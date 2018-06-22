<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${fns:getConfig('productName')} 登录</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">
.form-signin-heading {
	font-family: Microsoft YaHei;
	font-size: 36px;
	margin-top: 10px;
	margin-left: 10px;
	margin-bottom: 20px;
	color: #0663a2;
}

.form-signin {
	text-align: right;
	padding: 5px 30px 5px;
	margin: 0 auto 20px;
	background-color: #fff;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .checkbox {
	margin-bottom: 10px;
	color: #0663a2;
}

.form-signin #themeSwitch {
	font-size: 14px;
	position: absolute;
	right: 35px;
	bottom: 10px;
}

.form-signin div.validateCode {
	padding-bottom: 15px;
}

.mid {
	font-family: Microsoft YaHei;
	font-size: 16px;
	vertical-align: middle;
	color: #0663a2;
	font-weight: bold;
}

.alert {
	position: relative;
	width: 300px;
	margin: 0 auto;
	*padding-bottom: 0px;
}

label.error {
	background: none;
	width: 270px;
	font-weight: normal;
	color: inherit;
	margin: 0;
}

.itemImg {
	width: 60%;
	margin:0 auto;
}

/* 底部始终为default配色 */
#footer {
	color: #555555 !important;
	font-size: 14px !important;
	border-top: 2px solid #0663A2 !important;
	min-height: 25px !important;
}

.navbar-inner {
  min-height: 40px;
  padding-right: 20px;
  padding-left: 20px;
  background-color: #fafafa;
  background-image: -moz-linear-gradient(top, #ffffff, #f2f2f2);
  background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#f2f2f2));
  background-image: -webkit-linear-gradient(top, #ffffff, #f2f2f2);
  background-image: -o-linear-gradient(top, #ffffff, #f2f2f2);
  background-image: linear-gradient(to bottom, #ffffff, #f2f2f2);
  background-repeat: repeat-x;
  border: 1px solid #d4d4d4;
  -webkit-border-radius: 4px;
     -moz-border-radius: 4px;
          border-radius: 4px;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#fff2f2f2', GradientType=0);
  *zoom: 1;
  -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.065);
     -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.065);
          box-shadow: 0 1px 4px rgba(0, 0, 0, 0.065);
}
</style>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginForm").validate({
				rules: {
					validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
				},
				messages: {
					username: {required: "请填写用户名."},password: {required: "请填写密码."},
					validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
				},
				errorLabelContainer: "#messageBox",
				errorPlacement: function(error, element) {
					error.appendTo($("#loginError").parent());
				} 
			});
			
			$(".itemImg").each(function(){
				$(this).height(window.screen.availHeight * 0.5 + "px");
			});
			
			$('#myCarousel').carousel({
				interval: 3000
			});
		});
		// 如果在框架或在对话框中，则弹出提示并跳转到首页
		if(self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0){
			alert('您已登录超时或在其他地点登录，请重新登录！');
			top.location = "${ctx}";
		}
	</script>
</head>
<body id="body">
	<!--[if lte IE 6]><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 <a href="http://browsehappy.com" target="_blank">升级</a> 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
	<h1 class="form-signin-heading">幼儿园综合信息管理平台</h1>
	<div style="display:inline-block; width:100%">
		<img src="${ctxStatic}/images/logo.png" style="margin-left:10px;margin-bottom:5px;" onclick="window.open('http://www.neusoft.com/cn/')">
		<label class="mid">后台管理系统</label>
	</div>
	
	<div id="myCarousel" class="carousel slide" data-ride="carousel" >
	    <!-- 轮播（Carousel）指标 -->
	    <ol class="carousel-indicators" >
	        <li data-target="#myCarousel" data-slide-to="0" class="active" id="img" style="width:100%; height:40%;"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	        <li data-target="#myCarousel" data-slide-to="3"></li>
	    </ol>   
	    <!-- 轮播（Carousel）项目 -->
	    <div class="carousel-inner" >
	        <div class="item active">
	            <img src="${ctxStatic}/images/banner_bg1.jpg" class="itemImg" style="width:1200px">
	        </div>
	        <div class="item">
	            <img src="${ctxStatic}/images/banner_bg2.png" class="itemImg" style="width:1200px">
	        </div>
	        <div class="item">
	            <img src="${ctxStatic}/images/banner_bg3.jpg" class="itemImg" style="width:1200px">
	        </div>
	        <div class="item">
	            <img src="${ctxStatic}/images/banner_bg4.gif" class="itemImg" style="width:1200px">
	        </div>
	    </div>
	    <!-- 轮播（Carousel）导航 -->
	    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	
	<form id="loginForm" class="form-signin" action="${ctx}/login" method="post">
		<div class="" style="display:inline-block; width:100% ">
			<label class="input-label mid" style="margin-left:10px;" for="username">登录名</label>
			<input type="text" id="username" name="username" class="input-small required" style="font-weight:bold;margin-bottom:0;" value="" placeholder="登录名">
			<label class="input-label mid" style="margin-left:10px;" for="password">密码</label>
			<input type="password" id="password" name="password" class="input-small required" style="font-weight:bold;margin-bottom:0;" value="" placeholder="密码">
			
			<c:if test="${isValidateCodeLogin}">
				<label class="input-label mid" style="margin-left:10px;" for="validateCode">验证码</label>
				<sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;" />
			</c:if>
			
			<input class="btn btn-primary" style="font-weight:bold;margin-left:10px;" type="submit" value="登录"/>
		</div>
		
		<%-- <div class="controls">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="rememberMe" title="下次不需要再登录"><input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/> 记住我（公共场所慎用）</label>
		</div> --%>
		<div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}" style="text-align: left;">
			<button data-dismiss="alert" class="close">×</button>
			<label id="loginError" class="error">${message}</label>
		</div>
	</form>
	<div id="footer" class="navbar-inner navbar-fixed-bottom" style="text-align: center;">
		Copyright &copy; 2014-${fns:getConfig('copyrightYear')} <strong>幼儿园综合信息管理平台</strong> 
	</div>
<%-- 	${fns:getConfig('version')} - Powered By <a href="https://team.oschina.net/DreamerStudio" target="_blank">${fns:getConfig('author')}</a>  --%>
<%-- 	${fns:getConfig('productName')} --%>
</body>
</html>