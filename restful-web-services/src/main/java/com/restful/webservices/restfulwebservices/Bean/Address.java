package com.restful.webservices.restfulwebservices.Bean;

public class Address {
    private String Flatno,Streetname,City;
    private int pincode;
public Address(){

}
    public Address(String flatno, String streetname, String city, int pincode) {
        Flatno = flatno;
        Streetname = streetname;
        City = city;
        this.pincode = pincode;
    }

    public String getFlatno() {
        return Flatno;
    }

    public void setFlatno(String flatno) {
        Flatno = flatno;
    }

    public String getStreetname() {
        return Streetname;
    }

    public void setStreetname(String streetname) {
        Streetname = streetname;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
