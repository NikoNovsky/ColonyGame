<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E="
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colony Game!</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<h1 class='hello'>Hello to the Colony Game!</h1>
	<h3 class='hello'>Users List</h3>
	
	<ul>
		<c:forEach items="${users }" var="user">
			<li>${user.login } -  
				<a href="${pageContext.request.contextPath }/game/${user.id}" onclick='getuser_id'>PLAY!</a>
				<a class='index' href="${pageContext.request.contextPath }/user/update/${user.id}">Edit</a>
				<a class='confirm' href="${pageContext.request.contextPath }/user/delete/${user.id}">Delete</a>
		</c:forEach>
	</ul><br>
	<a href="${pageContext.request.contextPath }/user/add">Add new user</a><br><br><br><br>
	<a href="${pageContext.request.contextPath }/how">How to play a game?</a>
	<script>
		$(function() {
			$('.confirm').click(function(e) {
				e.preventDefault();
				if (window.confirm("Are you sure?")) {
					location.href = this.href;
				}
			});
		});
	</script>
	<script type="text/javascript">
	function getuser_id() {
	user_id = ${user.id};
}

</script>
</body>
</html>