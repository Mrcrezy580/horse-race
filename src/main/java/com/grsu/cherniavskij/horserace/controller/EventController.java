package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Event;
import com.grsu.cherniavskij.horserace.model.EventDTO;
import com.grsu.cherniavskij.horserace.model.Horse;
import com.grsu.cherniavskij.horserace.repository.EventRepository;
import com.grsu.cherniavskij.horserace.repository.HorseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {
    private final static String EVENT_PATH = "/event";
    private final EventRepository eventRepository;
    private final HorseRepository horseRepository;

    public EventController(EventRepository eventRepository, HorseRepository horseRepository) {
        this.eventRepository = eventRepository;
        this.horseRepository = horseRepository;
    }

    @GetMapping(EVENT_PATH + "/{id}")
    public Event getEventById(@PathVariable("id") Long id) {
        return eventRepository.getById(id);
    }
    @PostMapping(value = EVENT_PATH)
    public Long createEvent(@RequestBody EventDTO eventDTO) {
        Event event = new Event();
        event.setCoefficientEvent(eventDTO.getCoefficientEvent());
        event.setResultEvent(eventDTO.getResultEvent());
        event.setBookmaker(eventDTO.getBookmaker());
        event.setDateRegister(eventDTO.getDateRegister());
        event.setRaceName(eventDTO.getRaceName());
        List<Long> horses = eventDTO.getHorses();
        List<Horse> list = new ArrayList<>();
        horses.forEach(horse -> {
            list.add(horseRepository.getById(horse));
        });
        event.setHorses(list);

        Long idEvent = eventRepository.save(event).getId();
        return idEvent;
    }

    @PutMapping(EVENT_PATH + "/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody EventDTO eventDTO) {
        Event updateEvent = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not exist with id: " + id));
        updateEvent.setCoefficientEvent(eventDTO.getCoefficientEvent());
        updateEvent.setResultEvent(eventDTO.getResultEvent());
        updateEvent.setBookmaker(eventDTO.getBookmaker());
        updateEvent.setDateRegister(eventDTO.getDateRegister());
        updateEvent.setRaceName(eventDTO.getRaceName());
        List<Long> horses = eventDTO.getHorses();
        List<Horse> list = new ArrayList<>();
        horses.forEach(horse -> {
            list.add(horseRepository.getById(horse));
        });
        updateEvent.setHorses(list);
        return ResponseEntity.ok(updateEvent);
    }
    @DeleteMapping(value = EVENT_PATH + "/{id}")
    public ResponseEntity<Long> deleteEvent(@PathVariable Long id) {

        eventRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping(EVENT_PATH)
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}