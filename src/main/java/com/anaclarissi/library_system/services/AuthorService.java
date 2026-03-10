package com.anaclarissi.library_system.services;

import com.anaclarissi.library_system.entities.Author;
import com.anaclarissi.library_system.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> findAll() {

        return repository.findAll();

    }

    public Author findById(Long id) {

        Optional<Author> author = repository.findById(id);

        return author.orElseThrow(() -> new RuntimeException("Not found Id -> " + id));

    }

    public Author insert(Author author) {

        return repository.save(author);

    }

    public void deleteById(Long id) {

        repository.deleteById(id);

    }

    public Author update(Long id, Author author) {

        Author entity = repository.getReferenceById(id);

        updateDate(entity, author);

        return repository.save(entity);

    }

    private void updateDate(Author entity, Author author) {

        entity.setName(author.getName());

        entity.setBirthDate(author.getBirthDate());

    }

}
