package com.mycorp.birdobs.dao;

import org.springframework.data.repository.CrudRepository;

import com.mycorp.birdobs.models.Observation;

public interface ObservationDao extends CrudRepository<Observation, Integer> {

}