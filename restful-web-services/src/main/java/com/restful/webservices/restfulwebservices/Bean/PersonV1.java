package com.restful.webservices.restfulwebservices.Bean;

public class PersonV1 {
    private String name;
    private String address;
    public  PersonV1()
    {

    }
    public PersonV1(String name,String address) {
        this.name = name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
