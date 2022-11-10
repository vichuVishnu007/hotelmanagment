package com.app.hotelmanagment.controller;

import com.app.hotelmanagment.JwtUtils.JwtUtils;
import com.app.hotelmanagment.entity.APIResponse;
import com.app.hotelmanagment.entity.Client;
import com.app.hotelmanagment.service.myServicesInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class Clientcontroller {

    @Autowired
    private myServicesInter myservice;

    @Autowired
    private JwtUtils jutils;

    String response;

    @PostMapping("/user")
    public String registerUser(@RequestBody Client client) {
        System.out.println("Controller called");
        return myservice.AddUser (client);
    }


    @PostMapping("/login/{email}/{pwd}")
    public APIResponse loginValidate(@PathVariable String email, @PathVariable String pwd){
             return  myservice.loginValidation(email, pwd);
    }

    @PostMapping("/checkAvailability/{roomtype}/{fd}/{td}")
    public String checkAvailability(@RequestHeader("header") String header,@PathVariable String roomtype,@PathVariable String fd,@PathVariable String td) throws Exception {
        if(jutils.verify(header)=="1")
        {
           response= myservice.findroomAvailablity(roomtype,fd,td);
        }
        else
        {
            response=jutils.verify(header);
        }
        return response;
    }
}
