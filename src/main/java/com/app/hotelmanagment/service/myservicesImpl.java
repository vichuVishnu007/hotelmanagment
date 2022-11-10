package com.app.hotelmanagment.service;

import com.app.hotelmanagment.JwtUtils.JwtUtils;
import com.app.hotelmanagment.entity.APIResponse;
import com.app.hotelmanagment.entity.Client;
import com.app.hotelmanagment.repository.ClientRepository;
import com.app.hotelmanagment.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class myservicesImpl implements myServicesInter{

    @Autowired
    private ClientRepository repo;

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private JwtUtils jutils;

    @Autowired
    private ReservationRepo rsrepo;

    @Autowired
    Client client;

    String status ;

    public myservicesImpl(@Lazy JwtUtils jutils) {
        super();
        this.jutils = jutils;
    }

    @Override
    public String AddUser(Client client) {
        repo.save(client);
        return "Registered successfully...";
    }

    @Override
    public APIResponse loginValidation(String email, String pwd) {

        try {
            System.out.println(repo.getByemail(email).getEmail());
            if (repo.getByemail(email).getEmail().equals(email) && repo.getByemail(email).getPwd().equals(pwd)) {
                String token = jutils.generateJwt(client);
                Map<String, Object> data = new HashMap<>();
                data.put("accessToken", token);
                apiResponse.setStatus(1);
                apiResponse.setData(data);
            } else {
                System.out.println(repo.getByemail(email).getEmail() + " " + email);
                System.out.println(repo.getByemail(email).getPwd() + " " + pwd);
                apiResponse.setStatus(0); //Invalid user
                apiResponse.setData(null);
            }
        }
        catch (Exception e){
            apiResponse.setError(e.toString());
        }
        return apiResponse;
    }

    @Override
    public String findroomAvailablity(String roomtype, String fd, String td) {
        if(rsrepo.getByroomType(roomtype) ==null)
        {
            status="1";     //room available
        }
        else if(rsrepo.getByroomType(roomtype).getRoomType()!=roomtype && rsrepo.getByroomType(roomtype).getFromDate()!=fd){
            status="1";     //room available
        }
        else if( rsrepo.getByroomType(roomtype).getRoomType() == roomtype && rsrepo.getByroomType(roomtype).getFromDate()== fd)
        {
            status="0";
        }
        return status;
    }
}
