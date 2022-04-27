package com.kenIT.service.room;

import com.kenIT.model.Room;

import java.util.Comparator;

public class ComparatorPriceFromExpensiveToCheapInRoom implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
