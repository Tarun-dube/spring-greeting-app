package com.bridgelabz.greetingApp;

import com.bridgelabz.greetingApp.greetingClass.Greeting;
import com.bridgelabz.greetingApp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingRepo repo;


    @GetMapping("/hi")
    public List<Greeting> getAllGreetings(){
        return repo.findAll();
    }

    @PostMapping("/hi")
    public void addGreeting(@RequestBody Greeting greeting){
        repo.save(greeting);
    }
    @GetMapping("/hi/{id}")
        public Greeting getById(@PathVariable int id){
            return repo.findById(id).get();
        }


}
