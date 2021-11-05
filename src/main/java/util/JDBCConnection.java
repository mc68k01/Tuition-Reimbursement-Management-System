package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    // not a singleton

    private static Connection conn = null;
    public static Connection getConnection(){
        if (conn ==  null){
            // establish connection if null
            /* to establish connection we need 3 credentials:
            1) URL
            2) username
            3) password
             */

            String endpoint = "revature2109postgres128.cmkykkhe1pnv.us-east-2.rds.amazonaws.com";

            // URL format (postgres JDBC)
            // jdbc:postgresql://[endpoint]/[database]
            String url = "jdbc:postgresql://" + endpoint + "/postgres";
            String username = "victorgee";
            String password = "Dx^72$$$3EB2";
            try{
                conn = DriverManager.getConnection(url, username,password);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }

    /* this is for testing purposes,
    NOT needed to actually use JDBC  */

    public static void main(String[] args){
        Connection conn1 = getConnection();
        System.out.println(conn1);

    }

}
