package com.restful.webservices.restfulwebservices.Service;
import com.restful.webservices.restfulwebservices.Bean.Employee;
import com.restful.webservices.restfulwebservices.Controller.EmployeeController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

//Creating a rest controller
@Component
public class EmployeeDaoService {
        private static int count=4;
        private static List<Employee> list=new ArrayList<>();
        static {
            list.add(new Employee(1,"Varsha",25));
            list.add(new Employee(2,"Anshika",19));
            list.add(new Employee(3,"Rajat",27));
            list.add(new Employee(4,"Satyendra",24));
        }
        public List<Employee> findAll()
        {
           return list;
        }
        public Employee save(Employee employee)
        {
            if(employee.getId()==null)
            {
                employee.setId(++count);
            }
            list.add(employee);
            return employee;
        }
        public Employee findOne(int id)
        {
            for(Employee e:list)
            {
                if(e.getId()==id)
                    return e;
            }
            return null;
        }

public Employee deleteById(int id)
        {
            Iterator<Employee> iterator=list.iterator();
            while (iterator.hasNext()) {
                Employee e = iterator.next();
                if (e.getId() == id) {
                    iterator.remove();
                    return e;
                }
            }
            return null;
        }


    public void updateData(Employee employee, int id) {
        list.stream().map(v ->{
            if(v.getId()==id)
            {
                v.setName("Ritu");
                v.setAge(40);
            }
            return v;
        }).collect(Collectors.toList());
    }
}
