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

    public static final String IMG_PATH = "assets/images/avt/";
    public static final String DEFAULT_AVATAR = "assets/images/avt/Chef.png";
    private int id;
    private String role;
    private String email;
    private String password;
    private String avatar;
    private String name;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String address;
    private Date dateRegister;
    private boolean isActive = false;
    private int storeID;

    public User() {
    }

    public User(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
    }

    public User(int ID, String Role, String Email, String Password, String Avatar, String FirstName, String LastName, String Gender, String Phone, String Address, Date DateRegister, boolean IsActive, int StoreID) {
        this.id = ID;
        this.role = Role;
        this.email = Email;
        this.password = Password;
        this.avatar = Avatar;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.gender = Gender;
        this.phone = Phone;
        this.address = Address;
        this.dateRegister = DateRegister;
        this.isActive = IsActive;
        this.storeID = StoreID;
        this.name = firstName + " " + lastName;
    }

    public User(int ID, String Role, String Email, String Password, String Avatar,
            String FirstName, String LastName, String Gender, String Phone,
            String Address, Date DateRegister, int StoreID) {
        this(ID, Role, Email, Password, Avatar, FirstName, LastName, Gender, Phone, Address, DateRegister, true, StoreID);
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String Role) {
        this.role = Role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getAvatar() {
        if(avatar==null) return DEFAULT_AVATAR;
        return //IMG_PATH + 
                avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String Avatar) {
        this.avatar = Avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date DateRegister) {
        this.dateRegister = DateRegister;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean IsActive) {
        this.isActive = IsActive;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int StoreID) {
        this.storeID = StoreID;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + id + ", Role=" + role + ", Email=" + email + ", Password=" + password + ", Avatar=" + avatar + ", FirstName=" + firstName + ", LastName=" + lastName + ", Gender=" + gender + ", Phone=" + phone + ", Address=" + address + ", DateRegister=" + dateRegister + ", IsActive=" + isActive + ", StoreID=" + storeID + '}';
    }

}
