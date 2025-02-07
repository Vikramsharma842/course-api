package com.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courseapi.bean.Topic;
import com.courseapi.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAll();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);

	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
