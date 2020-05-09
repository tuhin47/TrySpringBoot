package com.tuhin.springboot.course;

import com.tuhin.springboot.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics/{topic}")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses(@PathVariable long topic) {
        return courseService.getCourses(topic);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@PathVariable long topic,@RequestBody Course course) {
        course.setTopic(new Topic(topic,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses")
    public void updateCourse(@RequestBody Course course) {
        courseService.update(course);
    }

}
