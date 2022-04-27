package com.kenIT.dto;

import java.util.Set;

public class SignUpDTO {
    private String name;
    private String userName;
    private String password;
    private String cMND;
    private Set<String> strRole;

    public SignUpDTO() {
    }

    public SignUpDTO(String name, String userName, String password, String cMND, Set<String> strRole) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.cMND = cMND;
        this.strRole = strRole;
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

    public Set<String> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<String> strRole) {
        this.strRole = strRole;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cMND='" + cMND + '\'' +
                ", strRole=" + strRole +
                '}';
    }
}
