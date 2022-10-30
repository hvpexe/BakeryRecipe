/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import dao.UserDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    private int following;
    private int follower;
    private Date dateRegister;
    private boolean isActive;
    private int storeID;
    private Date birthday;

    public User() {
    }

    public User(int id, String role, String email, String password, String avatar, String name, String firstName, String lastName, String gender, String phone, String address, Date dateRegister, boolean isActive, int storeID, Date birthday) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.name = lastName + " " + firstName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.dateRegister = dateRegister;
        this.isActive = isActive;
        this.storeID = storeID;
        this.birthday = birthday;
    }

    public User(int id, String role, String email, String password, String avatar, String name, String gender, String phone, String address, Date dateRegister, boolean isActive, int storeID, Date birthday) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.dateRegister = dateRegister;
        this.isActive = isActive;
        this.storeID = storeID;
        this.birthday = birthday;
    }

    public User(int id, String avatar, String name) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
    }
    
    public User(int id, String avatar, String name, int follower) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.follower = follower;
    }

    public User(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = lastName + " " + firstName;
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
        this.name = lastName + " " + firstName;
    }

    public User(int ID, String Role, String Email, String Password, String Avatar,
            String FirstName, String LastName, String Gender, String Phone,
            String Address, Date DateRegister, int StoreID) {
        this(ID, Role, Email, Password, Avatar, FirstName, LastName, Gender, Phone, Address, DateRegister, true, StoreID);
    }

    public User(int ID, String Role, String Email, String Password, String Avatar, String FirstName, String LastName, String Gender, String Phone, String Address, Date DateRegister, boolean IsActive, int StoreID, Date Birthday) {
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
        this.name = lastName + " " + firstName;
        this.birthday = Birthday;
    }

    public User(int ID, String Role, String Email, String Password, String Avatar,
            String FirstName, String LastName, String Gender, String Phone,
            String Address, Date DateRegister, int StoreID, Date Birthday) {
        this(ID, Role, Email, Password, Avatar, FirstName, LastName, Gender, Phone, Address, DateRegister, true, StoreID, Birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String Avatar) {
        this.avatar = Avatar;
    }

    public String getAvatar() {
        if (avatar == null) {
            return DEFAULT_AVATAR;
        }
        return IMG_PATH + avatar;
    }

    public String getAvatarToDB() {
        return avatar;
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

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int StoreID) {
        this.storeID = StoreID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday != null ? birthday : this.birthday;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", role=" + role + ", email=" + email + ", password=" + password + ", avatar=" + avatar + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", following=" + following + ", follower=" + follower + ", dateRegister=" + dateRegister + ", isActive=" + isActive + ", storeID=" + storeID + ", birthday=" + birthday + '}';
    }

    
}
