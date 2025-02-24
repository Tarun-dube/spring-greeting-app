package com.bridgelabz.greetingApp.greetingClass;

import org.springframework.stereotype.Service;

@Service
public class GreetingService{
    public String greet(String firstName, String lastName){
        if(firstName!=null && lastName!=null){
            return "Hello "+firstName+" "+lastName;
        }
        else if(firstName!=null && lastName==null){
            return "Hello "+firstName;
        }
        else if(firstName==null&&lastName!=null){
            return "Hello "+lastName;
        }

        return "Hello World";
    }
}
