<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<title>bieren</title>
<link rel='stylesheet'
	href='${pageContext.servletContext.contextPath}/styles/default.css'>
</head>
<body>

	<c:import url='/WEB-INF/JSP/index.jsp' />

	<h1>${brouwer.naam} (${brouwer.adres.gemeente})</h1>

	<ul>
		<c:forEach items='${bieren}' var='bier'>
			<li><spring:url var='url' value='/brouwers/{bierNr}'>
					<spring:param name='bierNr' value='${bier.bierNr}' />
				</spring:url> <a href='${url}'>${bier.naam}</a></li>
		</c:forEach>
	</ul>
	
</body>
</html>