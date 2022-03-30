<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "java.util.Iterator" %>
<%@page import= "com.training.model.User" %>
<%@page import= "java.util.List" %>
<%@page import= "com.training.dao.LoginDAOimpl" %>
<%@page import= "com.training.dao.LoginDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<% 
String username = (String)session.getAttribute("username");
String searchname = request.getParameter("searchname");
%>
<h2>You are logged in as : <%= username %>
and the message is : <%= session.getAttribute("message") %></h2>
<body>
<%
	LoginDAO loginDAO = new LoginDAOimpl();
	List<User> users = loginDAO.getUsersByUsername(searchname);
	Iterator<User> iterator = users.iterator();
%>
<h1>List of all the users</h1>
<table border="2" cellspacing="10" cellpadding="10">
<th>User ID</th>
<th>Username</th>
<th>Password</th>
<th>Gender</th>
<th>Notifications</th>
<th>Qualifications</th>

<% while(iterator.hasNext()){
	User user = iterator.next();
%>
<tr>
<td><%= user.getUserId() %></td>
<td><%= user.getUsername() %></td>
<td><%= user.getPassword() %></td>
<td><%= user.getGender() %></td>
<td><%= user.getNotification() %></td>
<td><%= user.getQualification() %></td>
</tr>

<% } %>
</br>
</br>
</br>
</br>
<a href="index.jsp">Logout</a> </br>
<a href="searchUser.jsp">Search Name</a>
</table>
</body>
</html>