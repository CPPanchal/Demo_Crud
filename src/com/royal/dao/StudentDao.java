package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.royal.bean.StudentBean;
import com.royal.util.DbConnection;

public class StudentDao {

	static Connection conn=null;
	boolean flag=false;
	PreparedStatement statement;
	int rowsAffected;
	
	
	public boolean insert(StudentBean bean)
	{
		conn=DbConnection.getConnectionObj();
		
		String str="INSERT INTO student VALUES(?,?,?,?,?,?,?)";	
		
		if(conn!=null)
		{
			System.out.println(conn);
		}
		else
		{
			System.out.println("not connected");
		}
		try {
			 statement=conn.prepareStatement(str);
			 statement.setString(1,bean.getFirstName());
			 statement.setString(2,bean.getLastName());
			 statement.setString(3,bean.getGender());
			 statement.setString(4,bean.getAddress());
			 statement.setString(5,bean.getContactNo());
			 statement.setString(6,bean.getUserId());
			 statement.setString(7,bean.getPassword());
			 
			 rowsAffected=statement.executeUpdate();
			if(rowsAffected>0)
			{
				flag=true;
			}
			else
			{
				System.out.println("Query Not Executed:");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return flag;
	}
	
	public ArrayList<StudentBean> show()
	{
		ArrayList<StudentBean> list=new ArrayList<StudentBean>();
		conn=DbConnection.getConnectionObj();
		ResultSet set=null;
		String str="SELECT *FROM student";
		
		try {
			statement=conn.prepareStatement(str);
			set=statement.executeQuery();
			while(set.next())
			{
				StudentBean bean=new StudentBean();
				bean.setId(set.getInt(1));
				bean.setFirstName(set.getString(2));
				bean.setLastName(set.getString(3));
				bean.setGender(set.getString(4));
				bean.setAddress(set.getString(5));
				bean.setContactNo(set.getString(6));
				bean.setUserId(set.getString(7));
				bean.setPassword(set.getString(8));
				list.add(bean);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
		
	}

	public ArrayList show(StudentBean bean) {
		
		ArrayList<StudentBean> list=new ArrayList<StudentBean>();
		conn=DbConnection.getConnectionObj();
		ResultSet set=null;
		String str="SELECT *FROM student where Id='"+bean.getId()+"'";
		
		try {
			statement=conn.prepareStatement(str);
			set=statement.executeQuery();
			while(set.next())
			{
				StudentBean bean1=new StudentBean();
				bean1.setId(set.getInt(1));
				bean1.setFirstName(set.getString(2));
				bean1.setLastName(set.getString(3));
				bean1.setGender(set.getString(4));
				bean1.setAddress(set.getString(5));
				bean1.setContactNo(set.getString(6));
				bean1.setUserId(set.getString(7));
				bean1.setPassword(set.getString(8));
				list.add(bean1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	
	}

	public void delete(StudentBean bean) {
		
		conn=DbConnection.getConnectionObj();
		
		String str="DELETE FROM student WHERE Id='"+bean.getId()+"'";
		
		try {
			statement=conn.prepareStatement(str);
			statement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void edit(StudentBean bean) {
	conn=DbConnection.getConnectionObj();
		
		String str="UPDATE student set FIRSTNAME=?,LASTNAME=?,GENDER=?,ADDRESS=?,CONTACTNO=?,USERID=?,PASSWORD=? WHERE ID=?";	
		
		if(conn!=null)
		{
			System.out.println(conn);
		}
		else
		{
			System.out.println("not connected");
		}
		try {
			 statement=conn.prepareStatement(str);
			 statement.setString(1,bean.getFirstName());
			 statement.setString(2,bean.getLastName());
			 statement.setString(3,bean.getGender());
			 statement.setString(4,bean.getAddress());
			 statement.setString(5,bean.getContactNo());
			 statement.setString(6,bean.getUserId());
			 statement.setString(7,bean.getPassword());
			 statement.setInt(8,bean.getId());
			 rowsAffected=statement.executeUpdate();
			if(rowsAffected>0)
			{
				flag=true;
			}
			else
			{
				System.out.println("Query Not Executed:");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
