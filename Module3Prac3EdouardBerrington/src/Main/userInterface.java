/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Account.Account;
import Contact.Contact;
import java.util.Scanner;
import module3prac3edouardberrington.contactFunctionality.Functions;

/**
 *
 * @author edoua
 */
public class userInterface {
   static void run(){
   Scanner scan=new Scanner(System.in);
   boolean running=false;
   Functions f =new Functions();
    int id;
   
   while(!running){
       try{
       menu();
   switch(scan.nextLine()){
   case("1"):
             RegisterUser();
             break;
       case("2"):
           System.out.println("Enter your username: ");
           String uname=scan.nextLine();
           System.out.println("Enter your password");
           String password=scan.nextLine();
           f.login(uname, password);
           break;
       case("3"):
           addContact();
           break;
       case("4"):
          System.out.println("Enter the ID of the contact that you wish to see:");
           id=Integer.parseInt(scan.nextLine());
          f.certainContact(id);
                  break;
       case("5"):
           f.allContacts();
           break;
       case("6"):
       updateContact();
       case("7"):
       System.out.println("Enter the ID of the contact that you wish to delete:");
       id=Integer.parseInt(scan.nextLine());
       f.deleteContact(id);
       break;
       case("8"):
       System.out.println("Enter the ID of the account that you wish to delete");
       id=Integer.parseInt(scan.nextLine());
       f.deleteAccount(id);
       break;
       case("9"):
           System.out.println("Hope you have a wonderful day");
           running=true;
           break;
       default:
           System.out.println("That is not an option");
           break;
   }
   }
   catch(NumberFormatException e){
   System.out.println("It appears you did something wrong");
   }
   }
   
   }
    static void menu(){
    System.out.println("Welcome enter the number of what you wish to do");
    System.out.println("1.Register user account");
    System.out.println("2.login user account");
    System.out.println("3. Add a contact");
    System.out.println("4 View a certain contact");
    System.out.println("5. View all contacts");
    System.out.println("6. Update a contact's details");
    System.out.println("7. Delete a contact");
    System.out.println("8. Delete an account");
    System.out.println("9. exit");
    }

    private static void RegisterUser() {
        Scanner scan=new Scanner(System.in);
        Functions f =new Functions();
        int uID;
        String firstname,surname,username,password;
        try{
        System.out.println("Enter a user ID");
        uID=Integer.parseInt(scan.nextLine());
        System.out.println("Enter your Firstname:");
        firstname=scan.nextLine();
        System.out.println("Enter your Surname: ");
        surname=scan.nextLine();
        System.out.println("Enter the username you would like to use:");
        username=scan.nextLine();
        System.out.println("Enter the password you would like to use:");
        password=scan.nextLine();
        Account ac=new Account(uID,firstname,surname,username,password);
        f.registerUser(ac);
        }catch(NumberFormatException e){System.out.println("You seem to have added something incorrectly ");}
    }

    private static void addContact() {
        boolean thing=true;
        int uID,contactID;
        String contactName,contactNumber,contactEmail=null;
        Scanner scan=new Scanner(System.in);
        Functions f =new Functions();
        try{
        System.out.println("Enter the contactID: ");
        contactID=Integer.parseInt(scan.nextLine());
        System.out.println("Enter the contact name: ");
        contactName=scan.nextLine();
        System.out.println("Enter the contactNumber: ");
        contactNumber=scan.nextLine();
        while(contactNumber.length()>10|contactNumber.length()<10){
        System.out.println("Please re-enter the number");
        contactNumber=scan.nextLine();
        if(contactNumber.length()==10){break;}
        }
        System.out.println("Do you wish to add an email? (1 for yes 2 for no)");
        while(thing){
        String choice=scan.nextLine();
        switch(choice){
            case("1"):
            System.out.println("Enter the contact email: ");
            contactEmail=scan.nextLine();
            thing=false;
            break;
            case("2"):
            contactEmail=null;
            thing=false;
            break;
            default:
                System.out.println("That is not a valid choice");
        }
        System.out.println("Enter the user ID of the user");
        uID=Integer.parseInt(scan.nextLine());
        
        Contact c=new Contact(contactID,contactName,contactNumber,contactEmail,uID);
        f.addContact(c);
        }
        }catch(NumberFormatException e){
        System.out.println("It appears something may have have happend");
        }
    }

    private static void updateContact() {
        boolean thing=true;
        int uID,contactID;
        String contactName,contactNumber,contactEmail=null;
        Scanner scan=new Scanner(System.in);
        Functions f =new Functions();
        try{
        System.out.println("Enter the contactID that you wish to update: ");
        contactID=Integer.parseInt(scan.nextLine());
        System.out.println("Enter the new contact name: ");
        contactName=scan.nextLine();
        System.out.println("Enter the new contactNumber: ");
        contactNumber=scan.nextLine();
        while(contactNumber.length()>10|contactNumber.length()<10){
        System.out.println("Please re-enter the number");
        contactNumber=scan.nextLine();
        if(contactNumber.length()==10){break;}
        }
        System.out.println("Do you wish to add an email? (1 for yes 2 for no)");
        while(thing){
        String choice=scan.nextLine();
        switch(choice){
            case("1"):
            System.out.println("Enter the contact email: ");
            contactEmail=scan.nextLine();
            thing=false;
            break;
            case("2"):
            contactEmail=null;
            thing=false;
            break;
            default:
                System.out.println("That is not a valid choice");
        }
        System.out.println("Enter the user ID of the user");
        uID=Integer.parseInt(scan.nextLine());
        
        Contact c=new Contact(contactID,contactName,contactNumber,contactEmail,uID);
        f.updateContact(c);
        }
        }catch(NumberFormatException e){
        System.out.println("It appears something may have have happend");
        }
    }
    
    public static void main(String args[]){
    run();
    }
}
