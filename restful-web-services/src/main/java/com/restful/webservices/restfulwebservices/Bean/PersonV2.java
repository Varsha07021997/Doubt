package com.restful.webservices.restfulwebservices.Bean;

public class PersonV2 {
    private Name name;
    private Address address;

    public PersonV2(Name name,Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public  PersonV2()
    {

    }
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
