package com.jishnu.bluebus.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bluebus","root","");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
