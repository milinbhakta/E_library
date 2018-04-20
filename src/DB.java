

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","milin","bhakta");
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://elibrary938.database.windows.net:1433;database=ELIBRARY;user=MILIN@elibrary938;password=9879662055MILU!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
