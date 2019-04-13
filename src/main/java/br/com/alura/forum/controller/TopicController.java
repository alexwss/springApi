package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.input.TopicSearchInputDto;
import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.repository.TopicRepository;

@RestController
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;

	@GetMapping(value="/api/topics", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutputDto> listTopics(TopicSearchInputDto topicSearch, 
			Pageable pageRequest){
		/*1
		Category subcategory = new Category("Java", new Category("Programação"));
		Course course = new Course("Java e JSF", subcategory);
		Topic topic = new Topic("Problemas com JSF",
				"Erro ao fazer conversão da data",
				new User("Fulano", "fulano@gmail.com", "123456"), course);
		
		List<Topic> topics = Arrays.asList(topic, topic, topic);*/
		
		Specification<Topic> topicSearchSpecification = topicSearch.build();
		Page<Topic> topics = this.topicRepository.findAll(topicSearchSpecification, pageRequest);
		
		return  TopicBriefOutputDto.listFromTopics(topics);
		
	}
	
}
