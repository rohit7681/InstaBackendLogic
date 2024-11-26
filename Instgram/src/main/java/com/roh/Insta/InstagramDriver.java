package com.roh.Insta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InstagramDriver {
	private static String url = "jdbc:mysql://localhost:3306/instagram";
	private static String user = "root";
	private static String password = "9938";
	public static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("For SignUp Enter :-1" + "\n" + "For Login to Your Account enter :-2" + "\n"
					+ "For Update your Account Enter :-3" + "\n" + "For delete Account Enter :-4" + "\n"
					+ "For Exist from Menu Enter :- 5" + "\n" + "\n" + "Enter your Choice:-");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				SignUp.signUp();
				System.out.println();
				break;
			case 2:
				LoginAccount.login();
				System.out.println();
				break;
			case 3:
				UpdateProfile.updateProfile();
				System.out.println();
				break;
			case 4:
				DeleteAccount.delete();
				System.out.println();
				break;
			case 5:
				System.out.println("Exist SucessFully");
				flag = false;
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
