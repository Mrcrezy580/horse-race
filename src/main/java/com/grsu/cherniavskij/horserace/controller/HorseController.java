package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Horse;
import com.grsu.cherniavskij.horserace.repository.HorseRepository;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
    @PostMapping(value = HORSES_PATH)
    public Long createHorse(@RequestBody Horse horse) {
        return horseRepository.save(horse).getId();
    }

    @PutMapping(HORSES_PATH + "/{id}")
    public ResponseEntity<Horse> updateHorse(@PathVariable long id, @RequestBody Horse horse) {
        Horse updateHorse = horseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Horse not exist with id: " + id));

        updateHorse.setAge(horse.getAge());
        updateHorse.setEquipmentWeight(horse.getEquipmentWeight());
        updateHorse.setFormEn(horse.getFormEn());
        updateHorse.setFormRu(horse.getFormRu());
        updateHorse.setNickName(horse.getNickName());
        updateHorse.setOwner(horse.getOwner());
        horseRepository.save(updateHorse);
        return ResponseEntity.ok(updateHorse);
    }
    @DeleteMapping(value = HORSES_PATH + "/{id}")
    public ResponseEntity<Long> deleteHorse(@PathVariable Long id) {

        horseRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
