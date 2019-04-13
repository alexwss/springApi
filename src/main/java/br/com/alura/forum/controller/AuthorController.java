package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.forum.models.Author;

@Controller
public class AuthorController {

	@RequestMapping(value = "/author" , method = RequestMethod.GET)
	private void list() {
		List<Author> authors;
		return;
	}
	
	
}
