package com.example.SpringDataJPAManyToManyMapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDataJPAManyToManyMapping.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
