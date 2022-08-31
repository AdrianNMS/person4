package com.bank.person3.service;

import com.bank.person3.models.entities.Person;

import java.util.List;

public interface PersonService
{
    List<Person> FindAll();
    Person Find(Long id);
    Person Create(Person person);
    Person Update(Long id, Person person);
    Boolean Delete(Long id);
}
