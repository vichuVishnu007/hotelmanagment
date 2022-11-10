package com.app.hotelmanagment.CustomActuatorEndpoint;

import com.app.hotelmanagment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoService implements InfoContributor {

    @Autowired
    ClientRepository repo;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String,String> AppInfo= new HashMap<>();
        AppInfo.put("AppName","HotelReservationSystem");
        AppInfo.put("Description","This application is used to reserve desired room on your desired time");
        AppInfo.put("Version","1.0.0");
        builder.withDetail("Application Info",AppInfo);
        Map<String,Integer> userCount= new HashMap<>();
        userCount.put("Number of Users",repo.findAll().size());
        builder.withDetail("UserDetails",userCount);
    }
}
