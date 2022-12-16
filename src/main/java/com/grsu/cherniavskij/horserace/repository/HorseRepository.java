package com.grsu.cherniavskij.horserace.repository;

import com.grsu.cherniavskij.horserace.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends JpaRepository <Horse,Long> {

}
