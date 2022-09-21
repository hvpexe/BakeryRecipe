/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author kichi
 */
public class User {
    public static final String IMG_PATH = "assets/images/mainavt/";
    private int ID;
    private String Role;
    private String Email;
    private String Password;
    private String Avatar;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Phone;
    private String Address;
    private Date DateRegister;
    private boolean IsActive;
    private int StoreID;

    public User() {
    }
    
    public User(int ID, String Role, String Email, String Password, String Avatar, String FirstName, String LastName, String Gender, String Phone, String Address, Date DateRegister, boolean IsActive, int StoreID) {
        this.ID = ID;
        this.Role = Role;
        this.Email = Email;
        this.Password = Password;
        this.Avatar = Avatar;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Address = Address;
        this.DateRegister = DateRegister;
        this.IsActive = IsActive;
        this.StoreID = StoreID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAvatar() {
        return IMG_PATH + Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDateRegister() {
        return DateRegister;
    }

    public void setDateRegister(Date DateRegister) {
        this.DateRegister = DateRegister;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }
    
    
}
