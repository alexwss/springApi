package br.com.alura.forumrepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alura.forum.models.Author;

@Repository
public interface AuthorRepository  {
	
	List<Author> findAll();

}
