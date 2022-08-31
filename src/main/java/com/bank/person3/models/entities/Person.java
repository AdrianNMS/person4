package com.bank.person3.models.entities;

import com.bank.person3.models.enums.PersonGenre;
import com.bank.person3.models.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "person")
public class Person extends Audit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private PersonGenre genre;
    private String documentId;
    private String phoneNumber;
    private String email;


}
