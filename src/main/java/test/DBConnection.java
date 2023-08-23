package test;
import java.sql.*;
public class DBConnection {
  private static Connection con = null;//reference Variable
  private DBConnection () {}
	  
	  static{
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","system","harsh");
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }//end Static block
		  public static Connection getCon()
		  {
		  return con;
		  }
	  }

	

