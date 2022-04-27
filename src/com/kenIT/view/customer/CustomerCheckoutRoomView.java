package com.kenIT.view.customer;

import com.kenIT.controller.RoomController;
import com.kenIT.model.Room;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;
import com.kenIT.service.room.RoomServiceImpl;
import com.kenIT.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerCheckoutRoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();
    public CustomerCheckoutRoomView(){
        List<Room> list = new ArrayList<>();

            for (int i = 0; i < RoomServiceImpl.roomList.size(); i++) {
                if (RoomServiceImpl.roomList.get(i).getCustomer() == null){
                  continue;
                } else if (RoomServiceImpl.roomList.get(i).getCustomer().getUserName().equals(CustomerCurrentServiceImpl.customerCurrentsList.get(0).getUserName())){
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
        System.out.println("Thanks you and See you again!");
        new Menu();
    }
}
