<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.royal.bean.StudentBean"%>
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
<%
		Iterator<StudentBean>itr = null;
		ArrayList<StudentBean>studentList=null;
		StudentBean bean=null;
			try{
					studentList=(ArrayList<StudentBean>)session.getAttribute("list");
					itr=studentList.iterator();
		
		while(itr.hasNext())
		{
			 bean=itr.next();
	%>	
	<form action="StudentController" method="get">
		
			<tr>
				<td><b>First Name</td>
				<td><input type="text" name="fn" value="<%=bean.getFirstName() %>"></td>
			</tr>
		
			
			<tr>
				<td><b>Last Name</td>
				<td><input type="text" name="ln" value="<%=bean.getLastName()%>"></td>
			</tr>
			
			
			<tr>
				<td><b>Gender</td>
				<td><input type="radio" name="gender" value="male">Male</td>
				<td><input type="radio" name="gender" value="female">Female</td>
			</tr>
			
			
			<tr>
				<td><b>Address</td>
				<td><textarea rows="5" cols="15"  name="add"><%=bean.getAddress()%></textarea>
			</tr>
	
			
			<tr>
				<td><b>ContactNo</td>
				<td><input type="number" name="no" value="<%=bean.getContactNo()%>"></td>
			</tr>
	
			<tr>
				<td><b>User-Id</td>
				<td><input type="text" name="uid" value="<%=bean.getUserId()%>"></td>
			</tr>
			
			<tr>
				<td><b>password</td>
				<td><input type="password" name="pass" value="<%=bean.getPassword() %>"></td>
			</tr>
			
			<tr>
				<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
				<td><input type="hidden" name="flag" value="edit"></td>
				<td><input type="submit" value="submit"></td>
			</tr>
			<%					
		}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		%>
	</form>
	
</table>


</body>
</html>