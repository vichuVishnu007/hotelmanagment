package com.app.hotelmanagment.repository;

import com.app.hotelmanagment.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<ReservationEntity,Integer> {

    public ReservationEntity getByroomType(String roomtype);
}
