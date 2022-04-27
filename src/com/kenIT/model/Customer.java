package com.kenIT.model;

import java.io.Serializable;
import java.util.Set;

public class Customer implements Serializable {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String age;
    private String gender;
    private String cMND;
    private String country;
    private Set<Role> roleSet;

    public Customer() {
    }


    public Customer(int id, String name, String userName, String password, String getcMND, Set<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.cMND = getcMND;
        this.roleSet = roleSet;
    }

    public Customer(String name, String cMND) {
        this.name = name;
        this.cMND =cMND;
    }

    public Customer(int id, String name, String userName, String password, String age, String gender, String cMND, String country, Set<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.cMND = cMND;
        this.country = country;
        this.roleSet = roleSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", cMND='" + cMND + '\'' +
                ", country='" + country + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }
}
