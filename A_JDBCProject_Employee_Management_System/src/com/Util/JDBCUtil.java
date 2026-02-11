package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "Mangesh@0214";

	public static Connection jdbcConnection() {
		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);

		}

		catch (ClassNotFoundException | SQLException e)

		{
			e.printStackTrace();
		}
		return con;
	}

}
