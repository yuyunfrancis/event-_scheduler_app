/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class Connect {
   private static Connection conn;
   private static Statement st;
   
   public static Statement Connection() {
       try{
          Class.forName("org.sqlite.JDBC");
           String url = "jdbc:sqlite:users.db";
           conn = DriverManager.getConnection(url);
           st = conn.createStatement();
           System.out.println("Connected");
       }
       catch(Exception ex){
           System.out.println("Connection failed");
       }
       return st;
         
       
   }
    public static void removerecord(String term){
       try{
           Connection();
            Statement st=conn.createStatement();
       int b=st.executeUpdate("delete from users where email='"+term+"';");
       if(b==1){
          JOptionPane.showMessageDialog(null, "chef deleted");
       } else{
       JOptionPane.showMessageDialog(null, "chef not found in system");
       }}
    catch(Exception e){
        e.printStackTrace();
    }}
}
