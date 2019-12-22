package com.tuhin.springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable long id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic t) {
		topicService.addTopic(t);
	}

	@RequestMapping(method = RequestMethod.PUT,value="/topics")
	public void updateTopic(@RequestBody Topic t) {
		topicService.update(t);
	}

}
