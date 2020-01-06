package com.tuhin.springboot.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopics() {
//		topicRepository.findTopicsOrderByName().forEach(item-> System.out.println(item.toString()));
//		System.out.println(topicRepository.findOneTopicByIdAndName(1,"a"));
//		System.out.println(topicRepository.findFirstTopicByName("a"));

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

	public List<Topic> getTopicGreaterThan(long id) {
		//return topicRepository.findByIdGreaterThan(id);
        return new ArrayList<>();
	}
}
