package com.bridgelabz.greetingApp;

import com.bridgelabz.greetingApp.greetingClass.Greeting;
import com.bridgelabz.greetingApp.greetingClass.GreetingService;
import com.bridgelabz.greetingApp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingRepo repo;

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simpleGreeting")
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message = greetingService.greet(firstName, lastName);
        return new Greeting(message);
    }

    @GetMapping("/hello")
    public Greeting greeting() {
        return new Greeting("Hello from Bridge Labz");
    }

    @PostMapping("/hello")
    public Greeting greetingPost(@RequestBody Greeting request){
        return new Greeting("Received: " + request.getGreeting()) ;  }

    @PutMapping("/hello/{name}")
    public Greeting greetingPut(@PathVariable String name, @RequestParam String lastName){
        return new Greeting("Updated: " + name + " " + lastName) ;
    }

    @DeleteMapping("/hello/{id}")
    public Greeting greetingDelete(@PathVariable String id){

        return new Greeting("Deleted: " + id);
    }
/// list all the messeages
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


        //delete message
     @DeleteMapping("/hi/{id}")
    public void deleteGreeting(@PathVariable int id){
        repo.deleteById(id);
     }



    //edit data from repository
    @GetMapping("/hi/query/{id}")
    public void editGreeting( @PathVariable int id,@RequestParam String newgreeting){
        repo.findById(id).get().setGreeting(newgreeting);
        repo.save( repo.findById(id).get());

    }


}
