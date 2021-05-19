package com.example.demo;

//long exercise 10
//ex6

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SimpleController
{
    static Random r = new Random();


    @GetMapping("/random")
    public String getRandomNum(@RequestParam(value = "number", defaultValue = "1000") int number)
    {
        int rand = r.nextInt(number) + 1;
        return String.format("<h2>%d</h2>", rand);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "a", defaultValue = "0") Integer a,
                           @RequestParam(value = "b", defaultValue = "0") Integer b)
    {
        return String.format("<h2>%d</h2>", a * b);
    }

    @GetMapping("/greet/{name}")
    public String helloName(@PathVariable("name") String name)
    {
        return String.format("<h2>Hello %s!</h2>", name);
    }


}
