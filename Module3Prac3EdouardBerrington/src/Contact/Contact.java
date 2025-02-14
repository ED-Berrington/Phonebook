/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contact;

/**
 *
 * @author edoua
 */
public class Contact {
    private int contactID;
    private String contactName;
    private String contactNumber;
    private String contactEmail;
    private int uID;

    public Contact(int contactID, String contactName, String contactNumber, String contactEmail, int uID) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.uID=uID;}

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getUserID() {
        return uID;
    }

    public void setUserID(int uID) {
        this.uID = uID;
    }
    
}
