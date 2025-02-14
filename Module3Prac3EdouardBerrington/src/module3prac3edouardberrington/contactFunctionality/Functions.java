/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module3prac3edouardberrington.contactFunctionality;
import Account.Account;
import Contact.Contact;
import java.sql.*;
import module3prac3edouardberrington.DBConfig.DBConfig;
/**
 *
 * @author edoua
 */
public class Functions extends DBConfig {
    DBConfig db=new DBConfig();

    
    public void registerUser(Account ac){
        try(Connection con=db.getConnector()){
    String reg="INSERT INTO user(userID,firstName,surname,username,password) VALUES(?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(reg);
    ps.setInt(1,ac.getUserID());
    ps.setString(2, ac.getFirstname());
   ps.setString(3, ac.getSurname());
   ps.setString(4, ac.getUsername());
   ps.setString(5, ac.getPassword());
   int res=ps.executeUpdate();
   if(res>0){System.out.println("User successfully added.");}
   else{
       System.out.println("Something went wrong");
   }
   ps.close();
    }catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
    }
        
    }
    public void login(String username,String password){
    try(Connection con=db.getConnector()){
    String reg="SELECT * FROM user WHERE username=? AND password=?";
    PreparedStatement ps=con.prepareStatement(reg);
    ps.setString(1, username);
    ps.setString(2, password);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
    int uID=rs.getInt("userID");
    String fname=rs.getString("firstame");
    String sname=rs.getString("surname");
    String usename=rs.getString("username");
    String pass=rs.getString("password");
    System.out.println("Welcome "+ fname+" "+ sname +" your username is: "+ usename +" your password is "+ pass);
    }

   
   rs.close();
   ps.close();
    }catch(SQLException e){
    System.out.println("Incorrect username or password");
    }
    
    }
    public void addContact(Contact co){
    try(Connection con=db.getConnector()){
    String reg="INSERT INTO contact(contactID,contactName,contactNumber,contactEmail,userID) VALUES(?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(reg);
    ps.setInt(1,co.getContactID());
    ps.setString(2,co.getContactName() );
   ps.setString(3,co.getContactNumber() );
   ps.setString(4,co.getContactEmail() );
   ps.setInt(5,co.getUserID() );
   int res=ps.executeUpdate();
   if(res>0){System.out.println("account successfully added.");}
   else{
       System.out.println("Something went wrong");
   
   }
   ps.close();
    }catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
    }
            
    }
    public void allContacts(){
    try(Connection con=db.getConnector()){
    String fetch="SELECT * FROM contact";
    Statement ps=con.createStatement();
    ResultSet rs=ps.executeQuery(fetch);
    while(rs.next()){
    int id=rs.getInt("contactID");
    String name=rs.getString("contactName");
    String number=rs.getString("contactNumber");
    String email=rs.getString("contactEmail");
    int uID=rs.getInt("userID");
    System.out.println("contact id: "+id+" name: "+name+" number: "+number+" email: "+email+" uID "+uID);
    }
    rs.close();
    ps.close();
    }
    catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
    }
}
        public void certainContact(int i){
    try(Connection con=db.getConnector()){
    String fetch="SELECT * FROM contact WHERE contactID="+i;
    Statement ps=con.createStatement();
    ResultSet rs=ps.executeQuery(fetch);
    while(rs.next()){
    int id=rs.getInt("contactID");
    String name=rs.getString("contactName");
    String number=rs.getString("contactNumber");
    String email=rs.getString("contactEmail");
    int uID=rs.getInt("userID");
    System.out.println("contact id: "+id+" name: "+name+" number: "+number+" email: "+email+" uID "+uID);
    }
    rs.close();
    ps.close();
    }
    catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
    }
}
        public void updateContact(Contact o){
    try(Connection con=db.getConnector()){
    String reg="UPDATE contact SET contactName=?, ContactNumber=?, contactEmail=?, userID=? WHERE contactID=?";
    PreparedStatement ps=con.prepareStatement(reg);
    
    
   ps.setString(1,o.getContactName() );
   ps.setString(2,o.getContactNumber() );
   ps.setString(3,o.getContactEmail() );
   ps.setInt(4,o.getUserID() );
   ps.setInt(5, o.getContactID());
   int res=ps.executeUpdate();
   if(res>0){System.out.println("contact successfully updated.");}
   else{
       System.out.println("Something went wrong");
   
   }
   ps.close();
    }catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
        }
        }
        
        
        
        
        
public void deleteContact(int i){
try(Connection con=db.getConnector()){
    String del="DELETE contacts WHERE contactID=?";
    PreparedStatement ps=con.prepareStatement(del);
    ps.setInt(1, i);
    int res=ps.executeUpdate();
    if(res>0){System.out.println("Contact is removed");}
    else{System.out.println("Contact does not exist");}
    
    ps.close();
    }
    catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
    }
}

public void deleteAccount(int i){
try(Connection con=db.getConnector()){
    String del="DELETE user WHERE userID=?";
    PreparedStatement ps=con.prepareStatement(del);
    ps.setInt(1, i);
    int res=ps.executeUpdate();
    if(res>0){System.out.println("Contact is removed");}
    else{System.out.println("Contact does not exist");}
    
    ps.close();
    }
    catch(SQLException e){
    System.out.println("Error has occcured make certain your database or connector is working");
    }
}
}
