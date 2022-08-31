package com.bank.person3.service.impl;

import com.bank.person3.models.entities.Person;
import com.bank.person3.models.repository.PersonRepository;
import com.bank.person3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonImpl implements PersonService
{
    @Autowired
    PersonRepository dao;

    @Override
    public List<Person> FindAll()
    {
        return dao.findAll();
    }

    @Override
    public Person Find(Long id) {
        var pOptional = dao.findById(id);

        return pOptional.orElse(null);
    }

    @Override
    @Transactional
    public Person Create(Person person) {
        return dao.save(person);
    }

    @Override
    @Transactional
    public Person Update(Long id, Person person) {
        if(dao.existsById(id))
            return dao.save(person);
        else
            return null;
    }

    @Override
    @Transactional
    public Boolean Delete(Long id) {
        if(dao.existsById(id))
        {
            dao.deleteById(id);
            return true;
        }
        else
            return false;

    }
}
