<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Hello and welcome to JSP</h1>

<%!
int num1;
String guestName="Richard";
%>
<% 
guestName = request.getParameter("gname");
int num2=0;
for(int i=1;i<=5;i++){ %>
<h1><%= guestName %></h1>
<% } %>

<% out.println(num1+num2); %>
<% out.println("Welcome: "+guestName); %><br/>
<%= "Welcome "+guestName %>
</body>
</html>