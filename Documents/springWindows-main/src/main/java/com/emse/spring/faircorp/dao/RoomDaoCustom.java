package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findRoom(Long id);
    List<Window> findAllWindows(Long room_id);
    List<Heater> findAllHeaters(Long room_id);
}
