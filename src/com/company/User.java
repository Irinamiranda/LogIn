package com.company;

public class User {
    private long id;
    private String userName;
    private String password;
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Username: " + getUserName() + " Password: " + getPassword();
    }
}
