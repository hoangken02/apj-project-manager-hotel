package com.kenIT.view.admin.room;

import com.kenIT.controller.RoomController;
import com.kenIT.model.Room;
import com.kenIT.service.room.RoomServiceImpl;
import com.kenIT.view.Menu;

import java.util.Scanner;

public class UpdateRoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();
    public UpdateRoomView(){
        System.out.println("===================================");
        System.out.println("List room: ");
        for (Room room:
             RoomServiceImpl.roomList) {
            System.out.println(room);
        }
        System.out.println("Input room you want update");
        int id = scanner.nextInt();
        System.out.println("Input check-in: ");
        String checkIn = scanner.nextLine();
        System.out.println("Input check-out: ");
        String checkOut = scanner.nextLine();
        System.out.println("Input price:");
        int price = scanner.nextInt();
        Room room = new Room(id,checkIn,checkOut,price);
        roomController.updateRoom(room);
        new Menu();
    }
}
