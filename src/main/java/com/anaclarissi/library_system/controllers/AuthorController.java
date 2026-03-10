package com.anaclarissi.library_system.controllers;

import com.anaclarissi.library_system.entities.Author;
import com.anaclarissi.library_system.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {

        List<Author> list = service.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {

        Author author = service.findById(id);

        return ResponseEntity.ok().body(author);

    }

    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody Author author) {

        author = service.insert(author);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(author.getId()).toUri();

        return ResponseEntity.created(uri).body(author);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        service.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {

        author = service.update(id, author);

        return ResponseEntity.ok().body(author);

    }

}
