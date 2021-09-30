package com.security.springJWT.user;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "userData")
public class UserData {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String managerName;
    private ArrayList<String> employees;

    public UserData() {
    }

    public UserData(UserData userData) {
        this.userName = userData.userName;
        this.password = userData.password;
        this.firstName = userData.firstName;
        this.lastName = userData.lastName;
        this.mobileNumber = userData.mobileNumber;
        this.managerName = "";
        this.employees = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public ArrayList<String> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<String> employees) {
        this.employees = employees;
    }
}
