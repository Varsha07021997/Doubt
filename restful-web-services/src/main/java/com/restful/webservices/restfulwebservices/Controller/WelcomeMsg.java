package com.restful.webservices.restfulwebservices.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//Controller
@RestController
@RequestMapping
public class WelcomeMsg
{
    //Firstly we will use Get Method and specify the path in Request Mapping or
    // We can simply specify path in Get Mapping
    @GetMapping(path="/Welcome-Msg")
    public String welcome()
    {
        return "Welcome to spring boot.";
    }
    //You can see output by http://localhost:8080/Welcome-Msg
}
