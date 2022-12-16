package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Event;
import com.grsu.cherniavskij.horserace.model.Horse;
import com.grsu.cherniavskij.horserace.repository.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    private final static String EVENT_PATH = "/event";
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping(EVENT_PATH + "/{id}")
    public Event getEventById(@PathVariable("id") Long id) {
        return eventRepository.getById(id);
    }
    @GetMapping(EVENT_PATH)
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}