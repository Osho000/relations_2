package com.example.relations.repositories;

import com.example.relations.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface  HobbyRepository  extends JpaRepository<Hobby, Long> {

    Optional<Hobby> findByType(String type);
}