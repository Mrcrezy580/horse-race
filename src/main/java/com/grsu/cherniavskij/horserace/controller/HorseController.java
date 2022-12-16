package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Horse;
import com.grsu.cherniavskij.horserace.repository.HorseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HorseController {
    private final static String HORSES_PATH = "/horses";
    private final HorseRepository horseRepository;

    public HorseController(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    @GetMapping(HORSES_PATH + "/{id}")
    public Horse getHorseById(@PathVariable("id") Long id) {
        return horseRepository.getById(id);
    }
    @GetMapping(HORSES_PATH)
    public List<Horse> getHorses() {
        return horseRepository.findAll();
    }
}
