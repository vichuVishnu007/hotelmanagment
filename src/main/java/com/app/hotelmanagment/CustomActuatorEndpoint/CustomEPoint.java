package com.app.hotelmanagment.CustomActuatorEndpoint;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="application-details")
public class CustomEPoint{

    Map<String,String> info = new HashMap<>();

    @PostConstruct
    public void initNotes(){
        info.put("ApplicationName","HotelReservationSystem");
        info.put("Author","Vishnu");
        info.put("Releasedate","08-11-2022");
    }


    @ReadOperation
    public Map<String,String> getApplicationInfo(){
        return info;
    }

}
