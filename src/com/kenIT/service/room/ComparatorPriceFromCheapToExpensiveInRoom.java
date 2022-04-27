package com.kenIT.service.room;

import com.kenIT.model.Room;

import java.util.Comparator;

public class ComparatorPriceFromCheapToExpensiveInRoom implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
