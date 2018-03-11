<%--
  Created by IntelliJ IDEA.
  User: arti
  Date: 8/19/17
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>File Upload</title>
</head>
<body>


<form method="POST" action="/fileupload/add" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><label path="name">Name</label></td>
            <td><input type="name" name="name" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>

****************************************Multi file upload*********************************

<form action="/fileupload/multiple" method="post" enctype="MULTIPART/FORM-DATA">

    <table>
        <tr>
            <td><label path="file">Select a file1 to upload</label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><label path="name">Name1</label></td>
            <td><input type="name" name="name" /></td>
        </tr>
        <tr>
        <tr>
            <td><label path="file">Select a file2 to upload</label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><label path="name">Name</label></td>
            <td><input type="name" name="name" /></td>
        </tr>
        <tr>

            <td>    <input type="submit" value="Upload"> Press here to upload the file!
            </td>
        </tr>
    </table>



</form>




</body>
</html>
