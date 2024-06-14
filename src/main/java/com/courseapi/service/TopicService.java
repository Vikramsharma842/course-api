package com.courseapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.courseapi.bean.Topic;

@Service
public class TopicService {

	List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("java", "CoreJava", "This is java description"),
			new Topic("spring", "Spring framework", "This is Spring description"),
			new Topic("javascript", "JavaScript", "This is JavaScript description")));

	public List<Topic> getAll() {
		return topics;
	}

	public Topic getTopicById(String id) {
		Topic topic = topics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
		return topic;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {

		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.remove(i);
			}
		}
	}

}
