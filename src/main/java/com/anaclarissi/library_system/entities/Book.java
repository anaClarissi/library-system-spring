package com.anaclarissi.library_system.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean available;
    private LocalDate registrationDate;
    private LocalDate updateDate;
    public Book () {}

    public Book(Long id, String title, boolean available, LocalDate registrationDate, LocalDate updateDate) {

        this.id = id;

        this.title = title;

        this.available = available;

        this.registrationDate = registrationDate;

        this.updateDate = updateDate;

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public boolean isAvailable() {

        return available;

    }

    public void setAvailable(boolean available) {

        this.available = available;

    }

    public LocalDate getRegistrationDate() {

        return registrationDate;

    }

    public void setRegistrationDate(LocalDate registrationDate) {

        this.registrationDate = registrationDate;

    }

    public LocalDate getUpdateDate() {

        return updateDate;

    }

    public void setUpdateDate(LocalDate updateDate) {

        this.updateDate = updateDate;

    }

    @Override
    public boolean equals(Object object) {

        if (object == null || getClass() != object.getClass()) return false;

        Book book = (Book) object;

        return available == book.available && Objects.equals(id, book.id) && Objects.equals(title, book.title);

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, available);

    }

}
