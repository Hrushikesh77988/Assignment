package com.example.MindBowserChallenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MindBowserChallenge.data.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager,Long> {

}
