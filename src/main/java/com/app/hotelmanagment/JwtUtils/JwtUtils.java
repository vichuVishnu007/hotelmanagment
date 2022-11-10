package com.app.hotelmanagment.JwtUtils;

import com.app.hotelmanagment.entity.Client;
import com.app.hotelmanagment.service.myServicesInter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service
public class JwtUtils {

    private static String secret = "This_is_secret";
    private static long expiryDuration = 60 * 60;

    public String generateJwt(Client client){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(Integer.toString(client.getUserid()))
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        claims.put("Id",client.getUserid());
        claims.put("Name",client.getFirstname()+client.getLastname());

        // generate jwt using claims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return "1"; //Valid token

        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }

    }
}
