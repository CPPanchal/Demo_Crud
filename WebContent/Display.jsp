<%@page import="java.util.Iterator"%>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
	<td>ID</d>
	<td>FIRSTNAME</td>
	<td>LASTNAME</td>
	<td>GENDER</td>
	<td>ADDRESS</td>
	<td>CONTACTNO</td>
	<td>USERID</td>
	<td>PASSWORD</td>
	<td colspan="2">Action</td>
</tr>	
	<%
		Iterator<StudentBean>itr = null;
		ArrayList<StudentBean>studentList=null;
			try{
					studentList=(ArrayList<StudentBean>)session.getAttribute("list");
					itr=studentList.iterator();
		
		while(itr.hasNext())
		{
			StudentBean bean=itr.next();
	%>		
		<tr>
			<td><%=bean.getId()%></td>
			<td><%=bean.getFirstName()%></td>
			<td><%=bean.getLastName()%></td>
			<td><%=bean.getGender()%></td>
			<td><%=bean.getAddress()%></td>
			<td><%=bean.getContactNo()%></td>
			<td><%=bean.getUserId()%></td>
			<td><%=bean.getPassword()%></td>
			<td> <a href="StudentController?id=<%=bean.getId()%>&flag=update">Update</a></td>
			<td> <a href="StudentController?id=<%=bean.getId()%>&flag=delete">Delete</a></td>
		</tr>		
	<%					
		}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		%>
</table>
</body>
</html>