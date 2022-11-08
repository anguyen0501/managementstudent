/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group3
 */
public class DBConnect {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://localhost:1433;databaseName=Student";
    public static String user = "sa";
    public static String pass = "123456";
    public static Connection cnn;

    public static boolean open() {
        try {
            if (cnn == null || cnn.isClosed()) {
                Class.forName(driver);
                cnn = DriverManager.getConnection(url, user, pass);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void close() {
        try {
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void close(PreparedStatement ps){
        try {
            if (ps !=null) {
            ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    public static void close(PreparedStatement ps, ResultSet rs){
        try {
            if (rs !=null) {
            rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close(ps);
    }
}
