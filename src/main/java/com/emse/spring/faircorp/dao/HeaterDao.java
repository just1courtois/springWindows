package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    @Query("select h from Heater h where h.name=:name")
    Heater findByName(@Param("name") String name);

   /* @Modifying
    @Query("delete from Heater h where h.room = ?1")
    Heater deleteByRoom(@Param("id") Long id);*/
}
