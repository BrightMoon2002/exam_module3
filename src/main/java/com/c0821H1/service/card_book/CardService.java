package com.c0821H1.service.card_book;

import com.c0821H1.model.BookCard;
import config.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class CardService implements ICardService {
    public static final String SELECT_ALL = "SELECT * FROM bookCards";
    public static final String INSERT_CARD = "INSERT INTO bookCards (idCard, idBook, idStudent, borrowDate, returnDate, status) value (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_BY_ID = "SELECT * FROM bookCards where idCard = ?";
    public static final String UPDATE_BY_ID = "UPDATE bookCards set idBook = ?, idStudent = ?, borrowDate = ?, returnDate = ?, status = false WHERE idCard = ?";
    public static final String DELETE_BY_ID = "DELETE from bookCards where idCard=?";
    public static final String SELECT_BY_CODE = "SELECT * FROM bookCards where idCard = ?";
    public static final String FIND_BORROW = "SELECT * FROM bookCards where status = true";
    private static Connection connection = SingletonConnection.getConnection();

    @Override
    public List<BookCard> findAll() {
        List<BookCard> bookCardList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String idCard = resultSet.getString("idCard");
                int idBook = resultSet.getInt("idBook");
                int idStudent = resultSet.getInt("idStudent");
                Date dateBorrow = resultSet.getDate("borrowDate");
                Date dateReturn = resultSet.getDate("returnDate");
                boolean status = resultSet.getBoolean("status");
                bookCardList.add(new BookCard(idCard, idBook, idStudent, status, dateBorrow, dateReturn));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookCardList;
    }

    @Override
    public void insert(BookCard bookCard) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARD);
            preparedStatement.setString(1,bookCard.getIdBookCard());
            preparedStatement.setInt(2, bookCard.getIdBook());
            preparedStatement.setInt(3, bookCard.getIdStudent());
            preparedStatement.setDate(4, bookCard.getBorrowDate());
            preparedStatement.setDate(5, bookCard.getReturnDate());
            preparedStatement.setBoolean(6, bookCard.isStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


@Override
    public BookCard select(int id) {
        BookCard bookCard = new BookCard();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String idCard = resultSet.getString("idCard");
                int idBook = resultSet.getInt("idBook");
                int idStudent = resultSet.getInt("idStudent");
                Date dateBorrow = resultSet.getDate("borrowDate");
                Date dateReturn = resultSet.getDate("returnDate");
                boolean status = resultSet.getBoolean("status");
                bookCard = new BookCard(idCard, idBook, idStudent, status, dateBorrow, dateReturn);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookCard;
    }

    @Override
    public boolean update(BookCard bookCard) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setInt(1, bookCard.getIdBook());
            preparedStatement.setInt(2, bookCard.getIdStudent());
            preparedStatement.setDate(3, bookCard.getBorrowDate());
            preparedStatement.setDate(4, bookCard.getReturnDate());
            preparedStatement.setString(5, bookCard.getIdBookCard());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    public boolean updateTrue(BookCard bookCard) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bookCards set status = false WHERE idCard = ?");
            preparedStatement.setString(1, bookCard.getIdBookCard());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }


    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate()>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    public BookCard selectCode(String code) {
        BookCard bookCard = new BookCard();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CODE);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String idCard = resultSet.getString("idCard");
                int idBook = resultSet.getInt("idBook");
                int idStudent = resultSet.getInt("idStudent");
                Date dateBorrow = resultSet.getDate("borrowDate");
                Date dateReturn = resultSet.getDate("returnDate");
                boolean status = resultSet.getBoolean("status");
                bookCard = new BookCard(idCard, idBook, idStudent, status, dateBorrow, dateReturn);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookCard;
    }
    public List<BookCard> findAllBorrow() {
        List<BookCard> bookCardList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BORROW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String idCard = resultSet.getString("idCard");
                int idBook = resultSet.getInt("idBook");
                int idStudent = resultSet.getInt("idStudent");
                Date dateBorrow = resultSet.getDate("borrowDate");
                Date dateReturn = resultSet.getDate("returnDate");
                boolean status = resultSet.getBoolean("status");
                bookCardList.add(new BookCard(idCard, idBook, idStudent, status, dateBorrow, dateReturn));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookCardList;
    }

}
