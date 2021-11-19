package com.c0821H1.service.book;

import com.c0821H1.model.Book;
import config.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    private static Connection connection = SingletonConnection.getConnection();
    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = resultSet.getInt("idBook");
                String nameBook = resultSet.getString("nameBook");
                String description = resultSet.getString("description");
                String author = resultSet.getString("Author");
                int quantity = resultSet.getInt("quantity");
                bookList.add(new Book(idBook, nameBook, author, description, quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public Book select(int id) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where idBook = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = resultSet.getInt("idBook");
                String nameBook = resultSet.getString("nameBook");
                String description = resultSet.getString("description");
                String author = resultSet.getString("Author");
                int quantity = resultSet.getInt("quantity");
                book = new Book(idBook, nameBook, description, author, quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean update(Book book) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books set nameBook = ?, Author = ?, description = ?, quantity = ? WHERE idBook = ? ");
            preparedStatement.setString(1, book.getNameBook());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getDescription());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.setInt(5, book.getId());
            rowUpdate = preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;

    }


    public static void main(String[] args) {
        BookService bookService = new BookService();
        bookService.findAll();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

@Override
    public Book selectByName(String name) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books where nameBook LIKE ?");
            name = "%" + name + "%";
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBook = resultSet.getInt("idBook");
                String nameBook = resultSet.getString("nameBook");
                String description = resultSet.getString("description");
                String author = resultSet.getString("Author");
                int quantity = resultSet.getInt("quantity");
                book = new Book(idBook, nameBook, description, author, quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

}
