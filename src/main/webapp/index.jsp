<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bootstrap Navbar Example</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    /* Additional Styles */
    body {
      padding-top: 70px; /* Adjust according to navbar height */
    }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Your Brand</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Services</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact</a>
      </li>
      
      <c:if test="${empty username}">
	      <li class="nav-item">
	        <a class="nav-link" href="/login">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link btn btn-primary" href="/register">Register</a>
	      </li>
      </c:if>
      	
      <c:if test="${not empty username}">
      	<li class="nav-item"> 
	    	<P class="nav-link">${username}</P>
	    </li>
      	<li class="nav-item">
	       <a class="nav-link btn btn-danger" href="/logout">Logout</a>
	     </li>
      </c:if>
    </ul>
  </div>
</nav>

<div class="container mt-5">
  <h1>Welcome to Your Website</h1>
  <p>Content of your website goes here...</p>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

</body>
</html>