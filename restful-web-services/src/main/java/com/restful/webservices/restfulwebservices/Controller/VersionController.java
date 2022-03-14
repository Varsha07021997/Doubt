package com.restful.webservices.restfulwebservices.Controller;

import com.restful.webservices.restfulwebservices.Bean.Address;
import com.restful.webservices.restfulwebservices.Bean.Name;
import com.restful.webservices.restfulwebservices.Bean.PersonV1;
import com.restful.webservices.restfulwebservices.Bean.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    //URI Versioning
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Varsha Saxena","B4,LIC Staff Quaters Rohini,Delhi,273001");
    }
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Varsha"," Saxena"),new Address("B4","LIC Staff Quaters Rohini","Delhi",273001));
    }

    //Request Parameter Versioning
    @GetMapping(value = "/person/param",params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Varsha Saxena","B4,LIC Staff Quaters Rohini,Delhi,273001");
    }
    @GetMapping(value = "/person/param",params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Varsha"," Saxena"),new Address("B4","LIC Staff Quaters Rohini","Delhi",273001));
    }
    //Custom Header versioning
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Varsha Saxena","B4,LIC Staff Quaters Rohini,Delhi,273001");
    }
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Varsha"," Saxena"),new Address("B4","LIC Staff Quaters Rohini","Delhi",273001));
    }

    //mime type versioning
    @GetMapping(value = "/person/produces",produces ="application/vnd.company.app-v1+json" )
    public PersonV1 producesV1(){
        return new PersonV1("Varsha Saxena","B4,LIC Staff Quaters Rohini,Delhi,273001");
    }
    @GetMapping(value = "/person/produces",produces ="application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Varsha"," Saxena"),new Address("B4","LIC Staff Quaters Rohini","Delhi",273001));
    }
}
