<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<title>bierhuis winkelwagen</title>
<link rel='stylesheet'
	href='${pageContext.servletContext.contextPath}/styles/default.css'>
</head>
<body>

	<c:import url='/WEB-INF/JSP/index.jsp' />

	<h1>Winkelwagen</h1>
	<table>
		<tr>
			<th>BierWijn</th>
			<th>Prijs</th>
			<th>Aantal</th>
			<th>Te Betalen</th>
		</tr>

		<c:forEach items="${winkelwagen.bestelbonlijnen}" var="bestelbonlijn">
			<tr>
				<td>${bestelbonlijn.bier.naam}
				<td class="right"><spring:eval
						expression="bestelbonlijn.bier.prijs"></spring:eval>
				<td class="right">${bestelbonlijn.aantal}</td>
				<td class="right"><fmt:formatNumber
						value="${bestelbonlijn.totaalPerLijn}" /></td>
			</tr>
		</c:forEach>

		<tr>
			<td class="right" colspan="4">Totaal: <fmt:formatNumber
					value="${winkelwagen.totaalVanBestelBon}" /></td>
		</tr>

	</table>

	<c:url value='/winkelwagen/bevestigen' var='url' />
	<form:form action='${url}' method='post' commandName='bestelbon'
		id='bevestigform'>
		<jsp:include page='klantenformFields.jsp' />
		<input type='submit' value='Als Bestelbon bevestigen'
			id='bevestigknop'>
	</form:form>
	<script>
		document.getElementById('bevestigform').onsubmit = function() {
			document.getElementById('bevestigknop').disabled = true;
		};
	</script>

</body>
</html>