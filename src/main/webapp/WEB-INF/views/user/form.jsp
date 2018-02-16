<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Colony Game!</title>
<link rel="Stylesheet" type="text/css" href="../style.css" />
</head>
<body>
	<form:form modelAttribute="user" method="post" class='form'>
		<form:hidden path="id" />
		<label class='form'>Login</label>
		<form:input path="login" class='form' />
		<br>
		<label class='form'>Password</label>
		<form:input path="password" class='form' type='password'/>
		<br><br>
		<form:button type="submit">Save</form:button>
	</form:form>
</body>
</html>