package com.app.hotelmanagment.service;

import com.app.hotelmanagment.entity.APIResponse;
import com.app.hotelmanagment.entity.Client;

public interface myServicesInter {

    public String AddUser(Client client);
    public APIResponse loginValidation(String email, String pwd);

    public String findroomAvailablity(String roomtype,String fd,String td);

}
