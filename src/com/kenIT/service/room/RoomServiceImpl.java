package com.kenIT.service.room;

import com.kenIT.config.ConfigReadAndWriteFile;
import com.kenIT.model.Customer;
import com.kenIT.model.Room;

import java.util.List;

public class RoomServiceImpl implements IRoomService {
    public static final String PATH_ROOM = ConfigReadAndWriteFile.PATH + ("\\room.txt");
    public static List<Room> roomList = new ConfigReadAndWriteFile().readFromFile(PATH_ROOM);

    @Override
    public List<Room> findAll() {
        new ConfigReadAndWriteFile().writeToFile(PATH_ROOM, roomList);
        return roomList;
    }

    @Override
    public Customer save(Room room) {
        roomList.add(room);
        return null;
    }

    @Override
    public Room findRoomById(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id){
                return roomList.get(i);
            }
        }
        return null;
    }

    @Override
    public Room updateRoom(Room room) {
        for (Room r:
             roomList) {
            if (r.getId() == room.getId()){
                r.setCheckIN(room.getCheckIN());
                r.setCheckOut(room.getCheckOut());
                r.setPrice(room.getPrice());
                return r;
            }
        }
        return null;
    }
}
