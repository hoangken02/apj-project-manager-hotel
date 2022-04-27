package com.kenIT.service.room;

import com.kenIT.model.Room;
import com.kenIT.service.IServiceGeneric;

public interface IRoomService extends IServiceGeneric<Room> {
    Room findRoomById(int id);
    Room updateRoom(Room room);
}
