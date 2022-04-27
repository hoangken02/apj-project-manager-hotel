package com.kenIT.view.admin.room;

import com.kenIT.controller.RoomController;
import com.kenIT.model.Room;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;
import com.kenIT.service.room.RoomServiceImpl;
import com.kenIT.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminCheckoutRoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();

    public AdminCheckoutRoomView() {
        List<Room> list = new ArrayList<>();

        for (int i = 0; i < RoomServiceImpl.roomList.size(); i++) {
            if (RoomServiceImpl.roomList.get(i).getCustomer() == null){
                continue;
            } else {
                list.add(RoomServiceImpl.roomList.get(i));
            }
        }

        for (Room r :
                list) {
            System.out.println(r);
        }
        System.out.println("Which room do you want check-out: ");
        int id = scanner.nextInt();
        roomController.checkoutRoom(id);
        System.out.println("Success checkout");
        new Menu();

    }

}
