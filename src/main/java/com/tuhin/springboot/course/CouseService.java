package com.tuhin.springboot.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CouseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCourses(long id) {
		return (List<Course>) courseRepository.findCoursesByTopicId(id);
	}
	
	public Course getCourse(long id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course t) {
		courseRepository.save(t);
	}

	public void update(Course t) {
		courseRepository.save(t);
	}

}
