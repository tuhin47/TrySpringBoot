package com.tuhin.springboot.overflow.q71522210;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
