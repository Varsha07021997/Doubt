package com.restful.webservices.restfulwebservices.Bean;

public class HelloWorldBean {
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    public HelloWorldBean(String name) {
    this.name=name;
    }
}
