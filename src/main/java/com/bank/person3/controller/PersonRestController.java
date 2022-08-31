package com.bank.person3.controller;

import com.bank.person3.handler.ResponseHandler;
import com.bank.person3.models.entities.Person;
import com.bank.person3.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person3")
public class PersonRestController
{
    @Autowired
    PersonService personService;

    private static final Logger log = LoggerFactory.getLogger(PersonRestController.class);


    @GetMapping
    public ResponseEntity<Object> FindAll()
    {
        log.info("[INIT] findAll Person");

        var people = personService.FindAll();

        if(!people.isEmpty())
        {
            log.info("[END] findAll Person");
            return ResponseHandler.response("Done", HttpStatus.OK,people);
        }
        else
        {
            return ResponseHandler.response("Error", HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> Find(@PathVariable Long id)
    {
        log.info("[INIT] Find Person");

        var person = personService.Find(id);

        if(person!=null)
        {
            log.info("[END] Find Person");
            return ResponseHandler.response("Done", HttpStatus.OK,person);
        }
        else
        {
            return ResponseHandler.response("Error", HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> Create(@RequestBody Person person)
    {
        log.info("[INIT] Create Person");

        var per = personService.Create(person);

        if(per!=null)
        {
            log.info("[END] Create Person");
            return ResponseHandler.response("Done", HttpStatus.OK,per);
        }
        else
        {
            return ResponseHandler.response("Error", HttpStatus.BAD_REQUEST, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> Update(@PathVariable Long id, @RequestBody Person person)
    {
        log.info("[INIT] Update Person");

        var per = personService.Update(id,person);

        if(per!=null)
        {
            log.info("[END] Update Person");
            return ResponseHandler.response("Done", HttpStatus.OK,per);
        }
        else
        {
            return ResponseHandler.response("Error", HttpStatus.BAD_REQUEST, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id)
    {
        log.info("[INIT] Delete Person");

        var del = personService.Delete(id);

        if(del)
        {
            log.info("[END] Delete Person");
            return ResponseHandler.response("Done", HttpStatus.OK,null);
        }
        else
        {
            return ResponseHandler.response("Error", HttpStatus.BAD_REQUEST, null);
        }
    }


}
