package com.app.hotelmanagment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userid;
    private String  Firstname;
    private String  Lastname;
    private String   email;
    private String  mobile;
    private String  address;
    private String  Pwd;

    public Client(int userid, String firstname, String lastname, String email, String mobile, String address, String pwd) {
        this.userid = userid;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.Pwd = pwd;
    }

    public Client() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        this.Pwd = pwd;
    }

    @Override
    public String toString() {
        return "Client{" +
                "userid=" + userid +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", Pwd='" + Pwd + '\'' +
                '}';
    }
}
