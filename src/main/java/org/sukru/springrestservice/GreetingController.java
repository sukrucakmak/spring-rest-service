package org.sukru.springrestservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String helloTemplate = "Hello, %s!";
    private final AtomicLong count = new AtomicLong();

    @GetMapping(path = "/greeting")
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "World") String name) {

        return new Greeting(count.incrementAndGet(), String.format(helloTemplate, name));
    }
}
