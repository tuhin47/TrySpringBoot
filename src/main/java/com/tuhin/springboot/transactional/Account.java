package com.tuhin.springboot.transactional;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@EnableAutoConfiguration
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ammount")
    private long ammount;
}