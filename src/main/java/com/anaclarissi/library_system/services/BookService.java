package com.anaclarissi.library_system.services;

import com.anaclarissi.library_system.entities.Book;
import com.anaclarissi.library_system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {

        return repository.findAll();

    }

    public Book findById(Long id) {

        Optional<Book> book = repository.findById(id);

        return book.orElseThrow(() -> new RuntimeException("Not found Id -> " + id));

    }

    public Book insert(Book book) {

        return repository.save(book);

    }

    public void deleteById(Long id) {

        repository.deleteById(id);

    }

    public Book update(Long id, Book book) {

        Book entity = repository.getReferenceById(id);

        updateDate(entity, book);

        return repository.save(entity);

    }

    private void updateDate(Book entity, Book book) {

        entity.setTitle(book.getTitle());

        entity.setAvailable(book.isAvailable());

        entity.setRegistrationDate(book.getRegistrationDate());

        entity.setUpdateDate(book.getUpdateDate());

    }

}
