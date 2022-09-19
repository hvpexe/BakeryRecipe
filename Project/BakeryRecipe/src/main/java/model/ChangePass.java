/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kichi
 */
public class ChangePass {
    public String password;
    public String newpassword;
    public String confirmnewpassword;

    public ChangePass() {
    }
    
    public ChangePass(String password, String newpassword, String confirmnewpassword) {
        this.password = password;
        this.newpassword = newpassword;
        this.confirmnewpassword = confirmnewpassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmnewpassword() {
        return confirmnewpassword;
    }

    public void setConfirmnewpassword(String confirmnewpassword) {
        this.confirmnewpassword = confirmnewpassword;
    }
    
}
