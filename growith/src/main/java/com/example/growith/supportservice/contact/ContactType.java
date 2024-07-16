package com.example.growith.supportservice.contact;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @OneToMany(mappedBy = "ContactType")
    private List<Contact> contactList;
}
