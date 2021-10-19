package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCustomImpl implements  HeaterDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void deleteByRoom(Long id) {
        String jpql = "delete from Heater h where h.room.id= :room_id";
        em.createQuery(jpql)
                .setParameter("room_id", id)
                .executeUpdate();
    }


}
