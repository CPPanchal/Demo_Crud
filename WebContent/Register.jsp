<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<form action="StudentController" method="post">
			<tr>
				<td><b>First Name</td>
				<td><input type="text" name="fn" value="${firstName}"><font color="red">${fstErr}</font></td>
			</tr>
		
			
			<tr>
				<td><b>Last Name</td>
				<td><input type="text" name="ln" value="${lastName}"><font color="red">${lstErr}</font></td>
			</tr>
			
			
			<tr>
				<td><b>Gender</td>
				<td><input type="radio" name="gender" value="male">Male</td>
				<td><input type="radio" name="gender" value="female">Female</td>
			</tr>
			
			
			<tr>
				<td><b>Address</td>
				<td><textarea rows="5" cols="15"  name="add" >${address}</textarea><font color="red">${addErr}</font></td>
			</tr>
	
			
			<tr>
				<td><b>ContactNo</td>
				<td><input type="number" name="no" value="${contactNo}"><font color="red">${noErr}</font></td>
			</tr>
	
			<tr>
				<td><b>User-Id</td>
				<td><input type="text" name="uid" value="${userId}"><font color="red">${IdErr}</font></td>
			</tr>
			
			<tr>
				<td><b>password</td>
				<td><input type="password" name="pass" value="${password}"><font color="red">${pwdErr}</font></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
			
			<tr>
				<td><a href="Search">SEARCH</a></td>
			</tr>
	
	</form>
</table>

</body>
</html>