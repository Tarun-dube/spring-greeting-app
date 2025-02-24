package com.bridgelabz.greetingApp;

import com.bridgelabz.greetingApp.greetingClass.Greeting;
import com.bridgelabz.greetingApp.greetingClass.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simpleGreeting")
    public Greeting simpleGreeting() {
        return new Greeting(greetingService.greet());
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
}
