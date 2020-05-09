package com.tuhin.springboot.course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseServiceTest {
    @Autowired
    CourseService courseService;

    @Test
    void getCourse() {
        System.err.println(courseService.getCourses(1).size());
    }
}