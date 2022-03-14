package com.restful.webservices.restfulwebservices.Controller;

import com.restful.webservices.restfulwebservices.Bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//import sun.jvm.hotspot.HelloWorld;

@RestController
public class HelloWorld_Path_Variable {
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVar(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World , %s", name));
    }

}