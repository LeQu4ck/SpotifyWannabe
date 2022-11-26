package proiectTehnologiiMobile;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class dbCon {
	
	Connection connection = null;
	static final String dataBase = "spotifywannabe";
	static final String url = "jdbc:mysql://localhost:3309/" + dataBase;
	
	static final String usn = "root";
	static final String psd = "root";
	
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, usn, psd);
    }
	
}
 