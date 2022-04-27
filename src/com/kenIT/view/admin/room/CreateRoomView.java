package com.kenIT.view.admin.room;

import com.kenIT.controller.RoomController;
import com.kenIT.dto.RoomNewDTO;
import com.kenIT.view.Menu;

import java.util.Scanner;

public class CreateRoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();

    public CreateRoomView() {
        System.out.println("================================");
        System.out.println("Create room view");
        System.out.println("Input price room: ");
        int price = scanner.nextInt();
        RoomNewDTO roomNewDTO = new RoomNewDTO(price);
        roomController.createRoom(roomNewDTO);
        System.out.println("Success create a new room");
        new Menu();
        System.out.println("================================");
    }
}
