package com.bridgelabz.greetingApp.repository;

import com.bridgelabz.greetingApp.greetingClass.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepo extends JpaRepository<Greeting, Integer> {
}
