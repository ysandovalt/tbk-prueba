package com.tbk.apisample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbk.apisample.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
