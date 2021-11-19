package com.c0821H1.model;

import java.sql.Date;

public class BookCard {
    private String idBookCard;
    private int idBook;
    private int idStudent;
    private boolean status;
    private Date borrowDate;
    private Date returnDate;

    public BookCard() {
    }

    public BookCard(int idBook, int idStudent, boolean status, Date borrowDate, Date returnDate) {
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BookCard(String idBookCard, int idBook, int idStudent, boolean status, Date borrowDate, Date returnDate) {
        this.idBookCard = idBookCard;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getIdBookCard() {
        return idBookCard;
    }

    public void setIdBookCard(String idBookCard) {
        this.idBookCard = idBookCard;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
