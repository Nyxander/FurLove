package connect;

import java.sql.*;

public class ConnectProvider {
     public static Connection getCon(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furlove","root", "");
             return con;
                     
             }
         catch(Exception e){
             e.printStackTrace(); 
             return null;
         }
     }
     
     public static void main(String[] args) {
         Connection con = ConnectProvider.getCon();
         if(con != null){
             System.out.println("Lidhja u realizua me sukses.");
         } else {
             System.out.println("Lidhja deshtoj.");
         }
     }
}