package com.toyota.dao;

import com.toyota.domain.Fault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FaultRepository extends JpaRepository<Fault, Long> {

    @Query("SELECT f FROM Fault f WHERE f.record_type = 'TEL'")
    List<Fault> findAllNecessaryFaults();
}
