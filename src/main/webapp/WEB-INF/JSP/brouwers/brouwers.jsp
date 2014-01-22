<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<title>bierhuis brouwers</title>
<link rel='stylesheet'
	href='${pageContext.servletContext.contextPath}/styles/default.css'>
</head>
<body>

	<c:import url='/WEB-INF/JSP/index.jsp' />

	<h1>Brouwers</h1>

	<ul>
		<c:forEach items='${brouwers}' var='brouwer'>
			<li><spring:url var='url' value='/brouwers/{brouwerNr}'>
					<spring:param name='brouwerNr' value='${brouwer.brouwerNr}' />
				</spring:url> <a href='${url}'>${brouwer.naam}</a></li>
		</c:forEach>
	</ul>
	
</body>
</html>