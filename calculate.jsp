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
<h1>Welcome to Calculate</h1>

<%
int num1=Integer.parseInt(request.getParameter("number1"));
int num2=Integer.parseInt(request.getParameter("number2"));

int op = Integer.parseInt(request.getParameter("operation"));

if (op == 1) {
	out.println(num1+num2);
}
else if (op == 2) {
	out.println(num1-num2);
}
else if (op == 3) {
	out.println(num1*num2);
}
else if (op == 4) {
	out.println(num1/num2);
}
%>
</body>
</html>