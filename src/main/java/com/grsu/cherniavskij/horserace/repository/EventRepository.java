package com.grsu.cherniavskij.horserace.repository;

import com.grsu.cherniavskij.horserace.model.Event;
import com.grsu.cherniavskij.horserace.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

}
