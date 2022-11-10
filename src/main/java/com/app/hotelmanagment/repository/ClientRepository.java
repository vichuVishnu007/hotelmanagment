package com.app.hotelmanagment.repository;

import com.app.hotelmanagment.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    public Client getByemail(String email);

}
