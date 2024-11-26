package com.roh.Insta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginAccount {

	public static void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------:For login into your instagram account:---------");
		System.out.println("Enter your User_Name:-");
		String user_name = sc.nextLine();
		System.out.println("Enter your Password:-");
		String password = sc.nextLine();
		System.out.println();
		if (UpdateProfile.validation(user_name, password)) {
			try {
				Statement st = InstagramDriver.con.createStatement();
				ResultSet r = st.executeQuery("select * from user_details where user_name='" + user_name
						+ "' and password='" + password + "'");
				while (r.next()) {
					System.out.println("User_name =" + r.getString("user_name"));
					System.out.println("Name =" + r.getString("name"));
					System.out.println("Age =" + r.getString("age"));
					System.out.println("Mobile =" + r.getString("mob"));
					System.out.println("Email =" + r.getString("email_id"));
				}
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else
			System.out.println("Invalid User Id and Password");

	}

}
