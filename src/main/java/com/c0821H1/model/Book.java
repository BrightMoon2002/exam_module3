package com.c0821H1.model;

public class Book {
    private int id;
    private String nameBook;
    private String Author;
    private String description;
    private int quantity;

    public Book() {
    }

    public Book(int id, String nameBook, String author, String description, int quantity) {
        this.id = id;
        this.nameBook = nameBook;
        Author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public Book(String nameBook, String author, String description, int quantity) {
        this.nameBook = nameBook;
        Author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
