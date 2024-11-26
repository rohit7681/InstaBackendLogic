package com.roh.Insta;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteAccount {

	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------:For deleting account from instagram:---------");
		System.out.println("Enter your User_Name:-");
		String user_name = sc.nextLine();
		System.out.println("Enter your Password:-");
		String password = sc.nextLine();
		if (UpdateProfile.validation(user_name, password)) {
			try {
				
				Statement st = InstagramDriver.con.createStatement();
				int n = st.executeUpdate(
						"delete from user_details where user_name='" + user_name + "' and password='" + password + "'");
				if (n > 0) {
					System.out.println("Your Account Deleted Sucessfully");
				}
			} catch ( SQLException e) {
				e.printStackTrace();
			} 

		} else {
			System.out.println("Invalid Input");
		}
	}

}
