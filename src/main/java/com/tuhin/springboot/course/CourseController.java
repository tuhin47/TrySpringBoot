package com.tuhin.springboot.course;

import com.tuhin.springboot.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics/{topic}")
public class CourseController {

    @Autowired
    private CouseService couseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses(@PathVariable long topic) {
        return couseService.getCourses(topic);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable long id) {
        return couseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@PathVariable long topic,@RequestBody Course course) {
        course.setTopic(new Topic(topic,"",""));
        couseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses")
    public void updateCourse(@RequestBody Course course) {
        couseService.update(course);
    }

}
