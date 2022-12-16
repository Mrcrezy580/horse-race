package com.grsu.cherniavskij.horserace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HorseRaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HorseRaceApplication.class, args);
    }

    @GetMapping(path = "/Horserace")
    public String lol() {
        return "horse";
    }
}
