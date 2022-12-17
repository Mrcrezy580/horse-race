package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.*;
import com.grsu.cherniavskij.horserace.repository.AccountRepository;
import com.grsu.cherniavskij.horserace.repository.BetRepository;
import com.grsu.cherniavskij.horserace.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BetController {
    private final static String BET_PATH = "/bet";
    private final BetRepository betRepository;
    private final EventRepository eventRepository;
    private final AccountRepository accountRepository;

    public BetController(BetRepository betRepository, EventRepository eventRepository, AccountRepository accountRepository) {
        this.betRepository = betRepository;
        this.eventRepository = eventRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping(BET_PATH + "/{id}")
    public Bet getBetById(@PathVariable("id") Long id) {
        return betRepository.getById(id);
    }
    @PostMapping(value = BET_PATH)
    public Long createBet(@RequestBody BetDTO betDTO) {
        Bet bet = new Bet();
        bet.setDateBet(betDTO.getDateBet());
        bet.setCoefficientBet(betDTO.getCoefficientBet());
        bet.setStatusBet(betDTO.getStatusBet());
        bet.setCalculate(betDTO.getCalculate());
        bet.setSum(betDTO.getSum());
        List<Long> events = betDTO.getEvents();
        List<Event> listEvents = new ArrayList<>();
        List<Long> accounts = betDTO.getAccounts();
        List<Account> listAccounts = new ArrayList<>();
        events.forEach(event -> {
            listEvents.add(eventRepository.getById(event));
        });
        accounts.forEach(account -> {
            listAccounts.add(accountRepository.getById(account));
        });
        bet.setEvents(listEvents);
        bet.setAccounts(listAccounts);
        return betRepository.save(bet).getId();
    }

    @PutMapping(BET_PATH + "/{id}")
    public ResponseEntity<Bet> updateBet(@PathVariable long id, @RequestBody BetDTO betDTO) {
        Bet updateBet = betRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bet not exist with id: " + id));
        updateBet.setDateBet(betDTO.getDateBet());
        updateBet.setCoefficientBet(betDTO.getCoefficientBet());
        updateBet.setStatusBet(betDTO.getStatusBet());
        updateBet.setCalculate(betDTO.getCalculate());
        updateBet.setSum(betDTO.getSum());
        List<Long> events = betDTO.getEvents();
        List<Event> listEvents = new ArrayList<>();
        List<Long> accounts = betDTO.getAccounts();
        List<Account> listAccounts = new ArrayList<>();
        events.forEach(event -> {
            listEvents.add(eventRepository.getById(event));
        });
        accounts.forEach(account -> {
            listAccounts.add(accountRepository.getById(account));
        });
        updateBet.setEvents(listEvents);
        updateBet.setAccounts(listAccounts);
        return ResponseEntity.ok(updateBet);
    }
    @DeleteMapping(value = BET_PATH + "/{id}")
    public ResponseEntity<Long> deleteBet(@PathVariable Long id) {

        betRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(BET_PATH)
    public List<Bet> getBets() {
        return betRepository.findAll();
    }
}
