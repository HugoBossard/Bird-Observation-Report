package com.mycorp.birdobs.dao;

import org.springframework.data.repository.CrudRepository;

import com.mycorp.birdobs.models.Report;

public interface ReportDao extends CrudRepository<Report, Integer> {

}