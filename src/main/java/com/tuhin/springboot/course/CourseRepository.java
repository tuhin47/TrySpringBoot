package com.tuhin.springboot.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    public List<Course> findCoursesByTopicId(long id);

}
