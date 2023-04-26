<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.message {
  float: right;
  text-align: right;
}
</style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
	<a class="navbar-brand" href="#">Magic Of Books</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item active">
				<a class="nav-link" href="login.jsp">Login</a>
			</li>
			<li class="nav-item active">
				<a class="nav-link" href="register.jsp">Register</a>
			</li>
		</ul>
	</div>
</nav>
	
	<h1 style="text-align:center; color:#704a77;">Read Later Books</h1>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Genre</th>
					<th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userbook }" var="book">
					<tr>
						<td>${book.bookId.book_name }</td>
						<td>${book.bookId.author }</td>
						<td>${book.bookId.genre }</td>
						<td><a style="margin: 7.5%" href="removereadlater/${book.id }"><i
								class="fa fa-trash" style="color: black"></i></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>