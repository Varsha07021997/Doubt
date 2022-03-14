package com.restful.webservices.restfulwebservices.Controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restful.webservices.restfulwebservices.Bean.UserBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filter-static")
    public UserBean retrieveStaticBean()
    {
        UserBean userBean= new UserBean("Varsha07","ttn123");
        return userBean;
    }

    //Dynamic filter(field1,field2)
    @GetMapping("/filter-dynamic")
    public MappingJacksonValue retrieveDynamicBean()
    {
        UserBean someBean= new UserBean("Varsha07","ttn123");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filters=new SimpleFilterProvider().addFilter("UserBeanFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        //return someBean;
        return mapping;
    }
    //Dynamic filter(field2,field3)
    @GetMapping("/filter-list")
    public List<UserBean> retrieveListUserBean()
    {
        UserBean someBean1= new UserBean("Varsha07","ttn123");
        UserBean someBean2= new UserBean("Rajat09","ttn123");

        return Arrays.asList(someBean1,someBean2);
    }
}
