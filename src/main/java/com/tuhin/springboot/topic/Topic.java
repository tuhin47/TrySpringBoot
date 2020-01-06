package com.tuhin.springboot.topic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@EnableAutoConfiguration
@ToString
public class Topic {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;

}
