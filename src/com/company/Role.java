package com.company;

import java.util.ArrayList;

public class Role {
    private long id;
    private String name;
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

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


    public void assignUser(User user) {
        if (user != null && !users.contains(user)) {
            users.add(user);
        }
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " name: " + getName();
    }
}
