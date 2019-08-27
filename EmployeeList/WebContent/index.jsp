<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Shopping</title>
</head>
<body>
	<!-- create forms for book editing -->
<!-- 	<table border="1"> -->
<!-- 		<tr> -->
<!-- 			<th>Book No.</th> -->
<!-- 			<th>Title</th> -->
<!-- 			<th>Author</th> -->
<!-- 			<th>Publisher</th> -->
<!-- 			<th>Year</th> -->
<!-- 			<th>Price</th> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- 	<form> -->
<%-- 	<% --%>
<!-- // 		out.println(request.getAttribute("table")); -->
<!-- // 		Object o = request.getAttribute("message"); -->
<!-- // 		if (o != null) -->
<!-- // 			out.println(o); -->
<%-- 	%> --%>
<!-- 	</form> -->
	<form action="EmployeeUpdate" method="post">
		Employee:
		Name:<br />
		<input type="text" name="eName"><br />
		Type:<br />
		<input type="text" name="eType"><br />
		Phone:<br />
		<input type="text" name="ePhone"><br />
		Email:<br />
		<input type="text" name="eEmail"><br />
		<input type="submit" value="submit"><br />
	</form>
</body>
</html>