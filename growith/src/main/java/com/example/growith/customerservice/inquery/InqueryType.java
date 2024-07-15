package com.example.growith.customerservice.inquery;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class InqueryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @OneToMany(mappedBy = "type")
    private List<Inquery> inqueryList;
}
