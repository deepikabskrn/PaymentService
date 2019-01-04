<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <c:choose>
<c:when test="${error!= null}">
<c:out value="${error}"/>
</c:when>
<c:otherwise>
Payment was successfull <br>
Your payment id is <c:out value="${id}"/>
</c:otherwise>
</c:choose>
</html>