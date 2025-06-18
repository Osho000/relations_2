package com.example.relations.repositories;

import com.example.relations.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public  interface PassportRepository extends JpaRepository<Passport, Long> {}