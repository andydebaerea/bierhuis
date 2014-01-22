<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>bierhuis welkom</title>
<link rel='stylesheet'
	href='${pageContext.servletContext.contextPath}/styles/default.css'>
</head>
<body>

	<jsp:include page='index.jsp' />
	
	<h1>Welkom in het huis van Belgische bieren</h1>
	
	<c:url value="/images/bierhuis.jpg" var="bierhuisFotoURL" />
	<img src="${bierhuisFotoURL}"
		alt="Welkom in het huis van Belgische bieren" />
		
	<p> We hebben momenteel ${totaalAantalBieren} bieren.</p>
</body>
</html>