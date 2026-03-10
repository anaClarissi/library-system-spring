package com.anaclarissi.library_system.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;

    public Author () {}

    public Author(Long id, String name, LocalDate birthDate) {

        this.id = id;

        this.name = name;

        this.birthDate = birthDate;

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public LocalDate getBirthDate() {

        return birthDate;

    }

    public void setBirthDate(LocalDate birthDate) {

        this.birthDate = birthDate;

    }

    @Override
    public boolean equals(Object object) {

        if (object == null || getClass() != object.getClass()) return false;

        Author author = (Author) object;

        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(birthDate, author.birthDate);

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, birthDate);

    }

}
