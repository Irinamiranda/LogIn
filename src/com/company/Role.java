package com.company;

public class Role {
    private long id;
    private String name;
    private User user;

    public Role(){

    }
    public Role(long id, String name){
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " name: " + getName();
    }
}
