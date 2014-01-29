<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
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
		<dd>
			<spring:eval expression="bier.prijs"></spring:eval>
			€
		</dd>
		<dt>Soort</dt>
		<dd>${bier.soort.naam}</dd>
		<dt>Bouwer</dt>
		<dd>${bier.brouwer.naam}</dd>
	</dl>

	<spring:url var='toevoegenURL' value='/bieren/toevoegen/{bierNr}'>
		<spring:param name='bierNr' value='${bier.bierNr}' />
	</spring:url>
	<form:form action="${toevoegenURL}" method="post"
		commandName="bestelbonlijnForm" id="aantalform">
		<jsp:include page="aantalitemsformfields.jsp"></jsp:include>
		<input type="submit" value="Toevoegen" id="aantalknop">
	</form:form>

	<script>
		document.getElementById('aantalform').onsubmit = function() {
			document.getElementById('aantalknop').disabled = true;
		};
	</script>


</body>
</html>