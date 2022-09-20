/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.lang.reflect.Field;

/**
 *
 * @author kichi
 */
public class User {

    private String ID;
    private String Role;
    private String Email;
    private String Password;
    private String Avatar;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Phone;
    private String Address;
    private String DateRegister;
    private String IsActive;
    private String StoreID;

    public User() {
    }

    public User(String ID, String Role, String Email, String Password, String Avatar, String FirstName, String LastName, String Gender, String Phone, String Address, String DateRegister, String IsActive, String StoreID) {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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
        return Avatar;
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

    public String getDateRegister() {
        return DateRegister;
    }

    public void setDateRegister(String DateRegister) {
        this.DateRegister = DateRegister;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String IsActive) {
        this.IsActive = IsActive;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String StoreID) {
        this.StoreID = StoreID;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", Role=" + Role + ", Email=" + Email + ", Password=" + Password + ", Avatar=" + Avatar + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Gender=" + Gender + ", Phone=" + Phone + ", Address=" + Address + ", DateRegister=" + DateRegister + ", IsActive=" + IsActive + ", StoreID=" + StoreID + '}';
    }

    
}
