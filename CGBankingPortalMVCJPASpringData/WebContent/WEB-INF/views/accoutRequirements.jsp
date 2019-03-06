 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
color:red;
font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h2>Give Details</h2>
<table>
<form:form action="accountCreation"  method="post"  modelAttribute="account">
<tr>
    <td> accountType:</td>
    <td><form:input path="accountType" size="30"/></td>
        <td><form:errors path="accountType" cssClass="error"/></td>
    </tr>
    <tr>
    <td>accountBalance:</td>
    <td><form:input path="accountBalance" size="30"/></td>
        <td><form:errors path="accountBalance" cssClass="error"/></td>
    </tr>
    <tr>
<td><input type="submit" value="Submit"/></td>
</tr>
    </form:form>
    </table>
    </div>
    </body>
    </html>