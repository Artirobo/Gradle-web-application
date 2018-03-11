<%--
  Created by IntelliJ IDEA.
  User: arti
  Date: 10/25/17
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>

<div class="container">



    <form:form method="POST" action="/addregistration" modelAttribute="usereg" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>

        <%--<spring:bind path="username">--%>
        <div >
            <form:input type="text" path="username" class="form-control" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
        </div>
        <div >
            <form:password  path="Password" class="form-control" placeholder="Password"
                        autofocus="true"></form:password>
            <form:errors path="Password"></form:errors>
        </div>

        <%--</spring:bind>--%>

        <c:if test="${empty usereg.username}">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
        </c:if>


    </form:form>
    <form action="<c:url value="/login" />" method="GET">
        <input type="submit" name="action" value="Back" />
    </form>

</div>



</body>
</html>

