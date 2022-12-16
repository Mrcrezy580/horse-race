package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Bet;
import com.grsu.cherniavskij.horserace.repository.BetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BetController {
    private final static String BET_PATH = "/bet";
    private final BetRepository betRepository;

    public BetController(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @GetMapping(BET_PATH + "/{id}")
    public Bet getBetById(@PathVariable("id") Long id) {
        return betRepository.getById(id);
    }

    @GetMapping(BET_PATH)
    public List<Bet> getBets() {
        return betRepository.findAll();
    }
}
