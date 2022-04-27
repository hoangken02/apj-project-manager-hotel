package com.kenIT.controller;

import com.kenIT.dto.RoomNewDTO;
import com.kenIT.model.Customer;
import com.kenIT.model.Room;
import com.kenIT.service.customer.CustomerServiceImpl;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;
import com.kenIT.service.room.RoomServiceImpl;

public class RoomController {
    RoomServiceImpl roomService = new RoomServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public void createRoom(RoomNewDTO roomNewDTO) {
        int id;
        if (RoomServiceImpl.roomList.size() == 0) {
            id = 1;
        } else {
            id = RoomServiceImpl.roomList.get(RoomServiceImpl.roomList.size() - 1).getId() + 1;
        }
        Room room = new Room(id, roomNewDTO.getPrice());
        roomService.save(room);
        roomService.findAll();
    }


    public void customerBookRoom(int id) {
        Customer customer = customerService.findCustomerByName(CustomerCurrentServiceImpl.customerCurrentsList.get(0).getUserName());
        roomService.findRoomById(id).setCustomer(customer);
        roomService.findAll();
    }

    public void adminBookRoom(int id, Room r) {
        Customer customer = customerService.save(r.getCustomer());
        customerService.findAll();
        Room room = roomService.findRoomById(id);
        room.setCustomer(customer);
        room.setCheckIN(r.getCheckIN());
        room.setCheckOut(r.getCheckOut());
        roomService.findAll();
    }

    public void checkoutRoom(int id) {
        roomService.findRoomById(id).setCustomer(null);
        roomService.findAll();
    }

    public void updateRoom(Room room) {
        roomService.updateRoom(room);
        roomService.findAll();
    }
}

