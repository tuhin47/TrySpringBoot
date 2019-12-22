package com.tuhin.springboot.course;

import com.tuhin.springboot.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;

	@ManyToOne
	private Topic topic;

}
