package com.kenIT.dto;

public class RoomNewDTO {
    private int price = 10000;

    public RoomNewDTO(int price) {
        this.price = price;
    }

    public RoomNewDTO() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomNewDTO{" +
                "price=" + price +
                '}';
    }
}
