package com.royal.util;

public class ValidationData {
	

	public static boolean isFirstNameValidate(String firstName)
	{
		
		/*if(userId.trim().length()>0 && userId!=null)
		{
			return flag;
		}
		else
		{
			flag=true;
			return flag;
		}*/
		return(firstName.trim().length()>0 && firstName!=null?true:false);

	}

	
	public static  boolean isLastNameValidate(String lastName)
	{
		/*if(password.trim().length()>0 && password!=null)
		{
			return flag;
		}
		else
		{
			flag=true;
			return flag;
		}*/
		return(lastName.trim().length()>0 && lastName!=null?true:false);
		
	}

	public static  boolean isaddValidate(String add)
	{
		return(add.trim().length()>0 && add!=null?true:false);
		
	}


	public static boolean isUserIdValidate(String userId) {
		// TODO Auto-generated method stub
		return(userId.trim().length()>0 && userId!=null?true:false);
	}


	public static boolean isContactNoValidate(String contactNo) {
		// TODO Auto-generated method stub
		return(contactNo.trim().length()>0 && contactNo!=null?true:false);
	}


	public static boolean ispwdValidate(String password) {
		// TODO Auto-generated method stub
		return(password.trim().length()>0 && password!=null?true:false);
	}
}
