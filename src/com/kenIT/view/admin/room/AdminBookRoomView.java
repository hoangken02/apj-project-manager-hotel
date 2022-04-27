package com.kenIT.view.admin.room;

import com.kenIT.controller.RoomController;
import com.kenIT.model.Customer;
import com.kenIT.model.Room;
import com.kenIT.service.room.ComparatorPriceFromCheapToExpensiveInRoom;
import com.kenIT.service.room.ComparatorPriceFromExpensiveToCheapInRoom;
import com.kenIT.service.room.RoomServiceImpl;
import com.kenIT.view.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdminBookRoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();
    List<Room> roomList = new ArrayList<>();
    public AdminBookRoomView(){
        System.out.println("========================================");
        for (int i = 0; i < RoomServiceImpl.roomList.size(); i++) {
            if (RoomServiceImpl.roomList.get(i).getCustomer() == null){
                roomList.add(RoomServiceImpl.roomList.get(i));
            }
        }
        for (Room room :
                roomList) {
            System.out.println(room);
        }
        System.out.println("========================================");

        if (roomList.size() == 0){
            System.out.println("Full room! See you again:");
            new Menu();
        }
        int choice;
        do {
            System.out.println("1. Sort room by price from cheap to expensive");
            System.out.println("2. Sort room by price from expensive to cheap");
            System.out.println("3. Book room");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Collections.sort(roomList, new ComparatorPriceFromCheapToExpensiveInRoom());
                    for (Room room :
                            roomList) {
                        System.out.println(room);
                    }
                    break;
                case 3:
                    for (Room r:
                            roomList) {
                        System.out.println(r);
                    }
                    break;
                case 2:
                    Collections.sort(roomList, new ComparatorPriceFromExpensiveToCheapInRoom());
                    for (Room room :
                            roomList) {
                        System.out.println(room);
                    }
                    break;
                default:
                    System.out.println("No find");
                    choice = -1;
            }
        } while (choice == -1);
        System.out.println("Which room do you want book?");
        int id = Integer.parseInt(scanner.next());
        System.out.println("Input your name: ");
        String name = scanner.next();
        System.out.println("Input your CMND: ");
        String cMND = scanner.next();
        System.out.println("Input check-in: ");
        String checkIn =scanner.next();
        System.out.println("Input check-out: ");
        String checkOut = scanner.next();
        Customer customer = new Customer(name,cMND);
        Room room = new Room(customer,checkIn,checkOut);
        roomController.adminBookRoom(id,room);
        System.out.println("Success book room");
        new Menu();
    }
}
