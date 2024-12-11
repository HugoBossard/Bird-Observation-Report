package com.mycorp.birdobs.dao;

import org.springframework.data.repository.CrudRepository;

import com.mycorp.birdobs.models.Users;

public interface UserDao extends CrudRepository<Users, Integer> {

}