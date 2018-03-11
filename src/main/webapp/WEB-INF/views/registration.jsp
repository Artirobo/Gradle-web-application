<%--
  Created by IntelliJ IDEA.
  User: arti
  Date: 8/19/17
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">



    <form:form method="POST" action="/add" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <form:input path="id" readonly="true" size="8"  disabled="true" placeholder="id" />
        <form:hidden path="id" />

        <%--<spring:bind path="username">--%>
            <div >
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        <%--</spring:bind>--%>

        <c:if test="${empty userForm.username}">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
        </c:if>
        <c:if test="${!empty userForm.username}">
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Edit</button>
        </c:if>
    </form:form>


    <h3>Persons List</h3>
    <c:if test="${!empty listPersons}">
        <table class="tg">
            <tr>
                <th width="80">UserId</th>
                <th width="120">User Name</th>

                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listPersons}" var="person">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.username}</td>

                    <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
                    <td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>


    <a href="/fileupload"  style="color: cadetblue">File</a>
    <br/><br/>
    <a href="/apicaller"  style="color: cadetblue">Api Caller</a>


    <a href="/autosearch"  style="color: cadetblue">auto Search</a>

    <a href="/login"  style="color: cadetblue">Security</a>

    <%--<a href="/login"  style="color: cadetblue">login</a>--%>

</div>
</body>
</html>
