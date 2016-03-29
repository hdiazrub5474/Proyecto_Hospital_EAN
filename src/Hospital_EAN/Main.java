/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_EAN;
import java.io.*;
import java.sql.*;
import javax.swing.*;



public class Main {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    static ResultSet rp=null;
    static ResultSet rr=null;
    static ResultSet rha=null;
    
    static String bd="XE";
    static String login="BDHOSPITAL";
    static String password="1234";
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    
    public static Connection Enlace(Connection conn)throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection(url,login,password);
        }
        catch(ClassNotFoundException e)
        {
            System.out.printf("Clase no encontrada");
        }
        return conn;
    } 
    
    public static Statement sta(Statement st)throws SQLException {
        conn=Enlace(conn);
        st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        return st;
    }
    
    public static ResultSet EnlEst(ResultSet rs)throws SQLException {
        st=sta(st);
        rs=st.executeQuery("select * from usuarios");
        return rs;
     
    }
    
    public static ResultSet EnlEstPac(ResultSet rh)throws SQLException {
        st=sta(st);
        rp=st.executeQuery("select * from paciente");
        return rp;
        
    }
    
        
}
