package com.kenIT.model;

import java.util.Set;

public class CustomerCurrent {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String cMND;
    private Set<Role> strRole;

    public CustomerCurrent() {
    }

    public CustomerCurrent(int id, String name, String userName, String password, String cMND, Set<Role> strRole) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.cMND = cMND;
        this.strRole = strRole;
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

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }

    public Set<Role> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<Role> strRole) {
        this.strRole = strRole;
    }

    @Override
    public String toString() {
        return "CustomerCurrent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cMND='" + cMND + '\'' +
                ", strRole=" + strRole +
                '}';
    }
}
