package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private  HeaterDao heaterDao;

    @Test

    public void shouldFindAHeater() {
        Heater heater = heaterDao.getById(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
    }

    public void shouldFindAWindow() {
        Window window = windowDao.getById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }


    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getById(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");

        
    }

    @Test
    public void shouldDeleteWindowsRoom() {
        Room room = roomDao.getById(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        windowDao.deleteByRoom(-10L);
        List<Window> result = windowDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}