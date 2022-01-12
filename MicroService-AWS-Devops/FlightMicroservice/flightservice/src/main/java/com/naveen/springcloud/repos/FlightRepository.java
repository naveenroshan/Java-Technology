package com.naveen.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.springcloud.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
