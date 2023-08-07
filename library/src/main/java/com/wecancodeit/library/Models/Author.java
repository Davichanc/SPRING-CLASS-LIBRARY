package com.wecancodeit.library.Models;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

//Database model for authors
@Entity
public class Author {
    // ID NECCESARY FOR SQL SERVER
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;

    @ManyToMany
    private Collection<Book> books;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Default used by JPA
    protected Author() {
    }

    public Collection<Book> getBooks() {
        return books;
    }

    

}
