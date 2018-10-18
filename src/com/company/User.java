package com.company;

import java.util.ArrayList;

public class User {
    private long id;
    private String userName;
    private String password;
    private ArrayList<Role> roles = new ArrayList<>();


    public User(){

    }

    public User(long id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void assignRole(Role role) {
        if (role != null && !roles.contains(role)) {
            roles.add(role);
        }
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Username: " + getUserName() + " Password: " + getPassword();
    }
}
