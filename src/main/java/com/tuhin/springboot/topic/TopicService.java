package com.tuhin.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopics() {
		return (List<Topic>) topicRepository.findAll();
	}
	
	public Topic getTopic(long id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic t) {
		topicRepository.save(t);
	}

	public void update(Topic t) {
		topicRepository.save(t);
	}

}
