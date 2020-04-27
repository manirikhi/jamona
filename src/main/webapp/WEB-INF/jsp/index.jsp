<!DOCTYPE html>
<%@taglib prefix="jwr" uri="http://jawr.net/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" data-ng-app="blogApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
<meta name="description" content="Info you tie to">
<meta name="keywords" content="blog,news,java,tiedot,tiedotinfo,blogs,tutorial,info,interview,html,css,javascript,mongodb">
<meta name="author" content="Rikhi">
<jwr:script src="/js/ems-core.js" />
<jwr:script src="/js/ems-app.js" />
<jwr:style src="/css/ems-core.css" />
<jwr:style src="/css/ems-app.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
@font-face {
  font-family: "Material-Design-Icons";
  src: url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.eot?");
  src: url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.eot?#iefix") format("embedded-opentype"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.woff2") format("woff2"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.woff") format("woff"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.ttf") format("truetype"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.svg#Material-Design-Icons") format("svg");
  font-weight: normal;
  font-style: normal;
}
@font-face {
	font-family: 'FontAwesome';
	src:
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.eot?v=4.3.0');
	src:
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.eot?#iefix&v=4.3.0')
		format('embedded-opentype'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.woff2?v=4.3.0')
		format('woff2'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.woff?v=4.3.0')
		format('woff'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.ttf?v=4.3.0')
		format('truetype'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.svg?v=4.3.0#fontawesomeregular')
		format('svg');
}
</style>
<script>
$(function(){

    $('.button-collapse').sideNav();

  }); // end of document ready
</script>
</head>
<body>
	<c:if test="${loginFlag}">
		<jsp:include page="blog-details-edit.jsp"></jsp:include>
	</c:if>
	<c:if test="${!loginFlag}">
		<jsp:include page="blog-details-view.jsp"></jsp:include>
	</c:if>
	<!-- Footer -->
	<jsp:include page="blog-footer.jsp"></jsp:include>
</body>
</html>