package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create an ArrayList to store Roles
        ArrayList<Role> roles = new ArrayList<>();
        //Adding elements into HashSet
        roles.add(new Role(12345, "Admin"));
        roles.add(new Role(12456, "Editor"));
        roles.add(new Role(13456, "Contributor"));

        //create an ArrayList to store users
        ArrayList<User> users = new ArrayList<>();
        //Adding elements into ArrayList
        users.add(new User(45678, "Andrey", "75935793565"));
        users.add(new User(45675, "Lora", "563658765783"));


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
                        Role role = selectRole(roles);
                        System.out.println("You logged in as " + role.getName());

                    } else {
                        break;
                    }
                }
            } else if (answer.equalsIgnoreCase("addrole")) {
                Role newRole = addnewRole( users);
                roles.add(newRole);
            } else if (answer.equalsIgnoreCase("adduser")) {
                User newUser = addNewUser(roles);
                users.add(newUser);
            } else if (answer.equalsIgnoreCase("listroles")) {
                System.out.println("--------Role list-------");
                for (Role eachRole : roles) {
                    System.out.println(eachRole + ", users: " + eachRole.getUsers());
                }
            } else if (answer.equalsIgnoreCase("listusers")) {
                System.out.println("---------User list---------");
                for (User eachuser : users) {
                    System.out.println(eachuser + ", roles: " + eachuser.getRoles());
                }
            } else if (answer.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    public static Role addnewRole( ArrayList<User> users) {
        Role newRole = new Role();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter role name");
        String name = scan.nextLine();
        newRole.setName(name);

        System.out.println("Enter ID");
        Long id = scan.nextLong();
        newRole.setId(id);

        assignUserToRole(newRole, users);

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

    public static Role selectRole(ArrayList<Role> roles) {
        System.out.println("----");
        for (int i = 0; i < roles.size(); i++) {
            Role a = roles.get(i);
            System.out.println((i + 1) + ": " + a);
        }
        System.out.println("Please select a role (or 0 to skip):");
        int idx = new Scanner(System.in).nextInt();
        return idx == 0 ? null : roles.get(idx - 1);

    }

    public static User assignRolesToUser(User user, ArrayList<Role> roles) {
        while (true) {
            Role role = selectRole(roles);
            if (role == null) {
                break;
            }
            user.assignRole(role);
        }
        return user;

    }
    public static Role assignUserToRole(Role role, ArrayList<User> users) {
        while (true) {
            User user = selectUser(users);
            if (user == null) {
                break;
            }
            role.assignUser(user);
        }
        return role;

    }


    public static User addNewUser(ArrayList<Role> roles) {
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

        assignRolesToUser(newUser, roles);



        return newUser;
    }
}
