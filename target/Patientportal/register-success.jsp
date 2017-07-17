<html>
<body>

<h1>Children National Hospital</h1>

 <%
	String info=request.getAttribute("status").toString();
	out.print(info);
%>

<a href="/patient-portal/login.jsp">Login</a>

</body>

</html>