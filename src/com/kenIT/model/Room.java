package com.kenIT.model;

import java.io.Serializable;

public class Room implements Comparable<Room>, Serializable {
    private  int id;
    private Customer customer;
    private  int price;
    private String checkIN;
    private String checkOut;

    public Room() {
        super();
    }

    public Room(int id, Customer customer, int price, String checkIN, String checkOut) {
        this.id = id;
        this.customer = customer;
        this.price = price;
        this.checkIN = checkIN;
        this.checkOut = checkOut;
    }

    public Room(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public Room(int id,String checkIn, String checkOut,int price) {
        this.id = id;
        this.checkIN = checkIn;
        this.checkOut = checkOut;
        this.price = price;
    }

    public Room(Customer customer, String checkIn, String checkOut) {
        this.customer =customer;
        this.checkIN = checkIn;
        this.checkOut = checkOut;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCheckIN() {
        return checkIN;
    }

    public void setCheckIN(String checkIN) {
        this.checkIN = checkIN;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", customer=" + customer +
                ", price=" + price +
                ", checkIN='" + checkIN + '\'' +
                ", checkOut='" + checkOut + '\'' +
                '}';
    }

    @Override
    public int compareTo(Room o) {
        return this.getCustomer().getName().compareTo(o.getCustomer().getName());
    }
}

