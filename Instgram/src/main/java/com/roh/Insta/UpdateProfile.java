package com.roh.Insta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateProfile {

	public static void updateProfile() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your User_Name:-");
		String user_name=sc.nextLine();
		System.out.print("Enter your Password:-");
		String password=sc.nextLine();
		if(validation(user_name,password)) {
			System.out.println("Enter your Choice Which u want Update");
			System.out.println("===============================================================================");
			System.out.println("For Update your Name press :-1"+"\n"+
					"For Update your Age press :-2"+"\n"+
					"For Update your Mob_Num press :-3"+"\n"+
					"For Update your Email press :-4"+"\n"+
					"For Update your Password press :-5"+"\n"
					+"\n"+"Enter your Choice:-");
		    String opt=sc.nextLine();
		    int option=Integer.parseInt(opt);
			try {
			    Statement st=InstagramDriver.con.createStatement();
			    switch(option) {
			    case 1:
			    	System.out.print("Input Name Which you want to modify:-");
					String name = sc.nextLine();
					name=name.toUpperCase();
					String q1="update user_details set name='"+name+"' where user_name='"+user_name+"' and password='"+password+"'";
					int num1=st.executeUpdate(q1);
					if(num1>0) {
						System.out.println("Name Updated SucessFully✅✅✅✅✅✅✅✅✅");
					}
					break;
			    case 2:
			    	System.out.print("Input your Age you want to modify:-");
					String age = sc.nextLine();
					String q2="update user_details set age='"+age+"' where user_name='"+user_name+"' and password='"+password+"'";
					int num2=st.executeUpdate(q2);
					if(num2>0) {
						System.out.println("Age Updated SucessFully✅✅✅✅✅✅✅✅✅");
					}
			    	break;
			    case 3:
			    	System.out.print("Input Mob_num Which you want to modify:-");
					String mobnum = sc.nextLine();
					String q3="update user_details set mob_num='"+mobnum+"' where user_name='"+user_name+"' and password='"+password+"'";
					int num3=st.executeUpdate(q3);
					if(num3>0) {
						System.out.println("Mob_num Updated SucessFully✅✅✅✅✅✅✅✅✅");
					}
			    	break;
			    case 4:
			    	System.out.print("Input Email Which you want to modify:-");
					String email = sc.nextLine();
					String q4="update user_details set email='"+email+"' where user_name='"+user_name+"' and password='"+password+"'";
					int num4=st.executeUpdate(q4);
					if(num4>0) {
						System.out.println("Email Updated SucessFully✅✅✅✅✅✅✅✅✅");
					}
			    	break;
			    case 5:
			    	String otp="";
			    	for(int i=1;i<=4;i++) {
			    		otp+=(int)(Math.random()*10);
			    	}
			    	System.out.print("Enter New Password:-");
		    		String password1=sc.nextLine();
			    	System.out.println("Your OTP = "+otp);
			    	System.out.print("Enter Your otp=");
			    	int otp1=sc.nextInt();
			    	int otp2=Integer.parseInt(otp);
			    	if(otp1==otp2) {
			    		String q5="update user_details set password='"+password1+"' where user_name='"+user_name+"' and password='"+password+"'";
			    		int num5=st.executeUpdate(q5);
			    		if(num5>0) {
			    			System.out.println("Password Updated SucessFully✅✅✅✅✅✅✅✅✅");
			    		}
			    	}
			    	else
			    		System.out.println("Entered Otp is Incorrect");
			    	break;
			   default:
				   System.out.println("Invalid input");
			    }
			} catch ( SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		else {
			System.out.println("Invalid User id and Password");
		}
	}
	
	
	public static boolean validation(String s1,String s2) {
		String user_name=s1;
		String password=s2;
		String user_name1="";
		String password1="";
		try {
			
			Statement st=InstagramDriver.con.createStatement();
			String q1="select user_name,password from user_details where user_name='"+user_name+"' and password='"+password+"'";
			ResultSet r=st.executeQuery(q1);
			while(r.next()) {
				user_name1=r.getString("user_name");
				password1=r.getString("password");
			}
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		if(user_name.equals(user_name1)) {
			return true;
		}
		return false;
	}
}
