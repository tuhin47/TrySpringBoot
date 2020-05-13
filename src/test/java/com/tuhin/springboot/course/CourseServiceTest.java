package com.tuhin.springboot.course;

import com.tuhin.springboot.topic.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseServiceTest {
    @Autowired
    CourseService courseService;
    @Autowired
    TopicRepository topicRepository;

    @Test
    void getCourse() {
        System.err.println(courseService.getCourses(1).size());
        topicRepository.findByDescriptionContainsOrNameContainsAllIgnoreCase("BB", "BB");
    }
}