package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create an ArrayList to store Roles
        ArrayList<Role> roles = new ArrayList<Role>();
        //Adding elements into HashSet
        roles.add(new Role(12345, "Admin"));
        roles.add(new Role(12456, "Editor"));
        roles.add(new Role(13456, "Contributor"));

        //create an ArrayList to store users
        ArrayList<User> users = new ArrayList<User>();


        while (true) {

            System.out.println("What do you wish to do? to log in [login]/to add role [addrole]/ to add user [adduser]/ to list roles[listroles]/ to list users [listusers]/exit");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("login")) {
                System.out.println("Enter the username");
                String userName = scan.nextLine();
                System.out.println("Enter the password");
                String password = scan.nextLine();
                for (User eachUser : users) {
                    if ((userName.equalsIgnoreCase(eachUser.getUserName()) && (password.equalsIgnoreCase(eachUser.getPassword())))) {
                        System.out.println("You logged in!");

                    } else {
                        break;
                    }
                }
            }else if (answer.equalsIgnoreCase("addrole")) {
                        Role newRole = addnewRole(null, users);
                        roles.add(newRole);
                    } else if (answer.equalsIgnoreCase("adduser")) {
                        User newUser = addnewUser(roles);
                        users.add(newUser);
                    } else if (answer.equalsIgnoreCase("listroles")) {
                        System.out.println("--------Role list-------");
                        for (Role eachRole : roles) {
                            System.out.println(eachRole.toString());
                        }
                    } else if (answer.equalsIgnoreCase("listusers")) {
                        System.out.println("---------User list---------");
                        for (User eachuser : users) {
                            System.out.println(eachuser.toString());
                        }
                    } else if (answer.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            }

    public static Role addnewRole(User definedUser, ArrayList<User> users) {
        Role newRole = new Role();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter role name");
        String name = scan.nextLine();
        newRole.setName(name);

        System.out.println("Enter ID");
        Long id = scan.nextLong();
        newRole.setId(id);
        User user = (definedUser == null) ? selectUser(users) : definedUser;

        newRole.setUser(user);
        System.out.println("new role: " + newRole);

        return newRole;

    }

    public static User selectUser(ArrayList<User> users) {
        System.out.println("----");
        for (int i = 0; i < users.size(); i++) {
            User a = users.get(i);
            System.out.println((i + 1) + ": " + a);
        }
        System.out.println("Please select a user (or 0 to skip):");
        int idx = new Scanner(System.in).nextInt();
        return idx == 0 ? null : users.get(idx - 1);

    }


    public static User addnewUser(ArrayList<Role> roles) {
        User newUser = new User();

        System.out.println("Enter your username");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        newUser.setUserName(userName);

        System.out.println("Enter your password");
        String password = scan.nextLine();
        newUser.setPassword(password);

        System.out.println("Enter your ID");
        long id = scan.nextLong();
        newUser.setId(id);

        while (true) {

            System.out.println("add role? y/n ");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("y")) {

                Role newRole = addnewRole(newUser, null);
                roles.add(newRole);

            } else {

                break;

            }

        }
        return newUser;
    }
}
