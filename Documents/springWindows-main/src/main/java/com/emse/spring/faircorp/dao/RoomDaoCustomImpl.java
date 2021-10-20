package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoom(Long id) {
        String jpql = "select w from Window where id = :id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Window> findAllWindows(Long room_id) {
        String jpql = "select w from Window where w.room.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", room_id)
                .getResultList();
    }

    @Override
    public List<Heater> findAllHeaters(Long room_id) {
        String jpql = "select h from Heater where h.room.id = :id";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", room_id)
                .getResultList();
    }

    @Override
    public void deleteByBuildingId(Long building_id){
      //à faire
    }


    @Override
    public void deleteRoom(Long room_id){
        String jpql = "delete r from Room where r.id = :id";
        String jpqlw = "delete w from Window where w.room.id = :id";
        String jpqlh = "delete h from Heater where h.room.id = :id";
        em.createQuery(jpql)
                .setParameter("id", room_id)
                .executeUpdate();
        em.createQuery(jpqlh)
                .setParameter("id", room_id)
                .executeUpdate();
        em.createQuery(jpqlw)
                .setParameter("id", room_id)
                .executeUpdate();
    }


}