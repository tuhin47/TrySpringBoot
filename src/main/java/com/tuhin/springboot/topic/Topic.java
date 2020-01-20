package com.tuhin.springboot.topic;

import javax.persistence.*;

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
	@Column(name = "topic")
	private String name;
	@Column(name = "topic_description")
	private String description;

}
