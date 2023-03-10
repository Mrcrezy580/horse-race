package com.grsu.cherniavskij.horserace.repository;

import com.grsu.cherniavskij.horserace.model.Account;
import com.grsu.cherniavskij.horserace.model.Bet;
import com.grsu.cherniavskij.horserace.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet,Long> {
}
