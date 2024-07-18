package com.example.demo.Entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Getter
@Setter
public class Student {
    @Id
    private int id;
    private String cname;
    private String tname;
}
