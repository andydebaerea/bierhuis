<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<form:label path='aantal'>Aantal
<form:errors path='aantal' cssClass='fout' />
</form:label> 
<form:input path='aantal' type='number' autofocus='autofocus' />