package com.bank.person3.models.repository;

import com.bank.person3.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
