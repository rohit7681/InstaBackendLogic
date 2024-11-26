package com.roh.Insta;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {

	public static void signUp() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name:-");
		String name = sc.nextLine();
		name = name.toUpperCase();
		System.out.print("Enter Mob:-");
		String mob = sc.nextLine();
		System.out.print("Enter Email:-");
		String email = sc.nextLine();
		System.out.print("Enter User_Name:-");
		String user_name = sc.nextLine();
		System.out.print("Enter Password:-");
		System.out.print("Password Most Contain atleast one CapitalLetter(A-Z)" + "\n"
				+ "Password Most Contain atleast one SmallLetter(a-z)" + "\n"
				+ "Password Most Contain atleast one Number(0-9)" + "\n"
				+ "Password Most Contain atleast one SpecialCharacter" + "\n"
				+ "Length Of the Password must have greaterthan 4 :-");
		String password = sc.nextLine();
		String exp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{4,}";
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			System.out.print("Enter Age:-");
			String age = sc.nextLine();
			int age1 = Integer.parseInt(age);
			if (age1 >= 13) {
				try {
					Statement st =InstagramDriver. con.createStatement();
					String q1 = "insert into user_details values('" + name + "','" + age + "','" + mob + "','" + email
							+ "','" + password + "','" + user_name + "')";
					int n = st.executeUpdate(q1);
					if (n > 0) {
						System.out.println("SignUp completed");
					}
				} catch ( SQLException e) {
					e.printStackTrace();
				}

			} else
				System.out.println("You are not eligible to create Instagram Account");

		} else
			System.out.println("Please Enter The Password in correct formate");

	}

}
