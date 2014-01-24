<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<title>bier</title>
<link rel='stylesheet'
	href='${pageContext.servletContext.contextPath}/styles/default.css'>
</head>
<body>

	<c:import url='/WEB-INF/JSP/index.jsp' />

	<h1>${bier.naam}</h1>

	<dl>
		<dt>Alcohol</dt>
		<dd>
			<spring:eval expression="bier.alcohol"></spring:eval>
			%
		</dd>
		<dt>Prijs</dt>
		<dd><spring:eval expression="bier.prijs"></spring:eval> €</dd>
		<dt>Soort</dt>
		<dd>${bier.soort.naam}</dd>
		<dt>Bouwer</dt>
		<dd>${bier.brouwer.naam}</dd> </dl>
		
		<spring:url var='toevoegenURL' value='/winkelwagen/toevoegen/{bierNr}'>
					<spring:param name='bierNr' value='${bier.bierNr}' />
				</spring:url>
	<form action="${toevoegenURL}" method="post">
		<label>Aantal <c:if test="${not empty aantal}">
			</c:if> <input type="number" name="aantal" autofocus
			/></label><span class="fout">${fout}</span> <input
			type="submit" value="Toevoegen">
	</form>

	


</body>
</html>