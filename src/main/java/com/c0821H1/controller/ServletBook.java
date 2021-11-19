package com.c0821H1.controller;

import com.c0821H1.model.Book;
import com.c0821H1.model.BookCard;
import com.c0821H1.model.Student;
import com.c0821H1.service.book.BookService;
import com.c0821H1.service.book.IBookService;
import com.c0821H1.service.card_book.CardService;
import com.c0821H1.service.card_book.ICardService;
import com.c0821H1.service.student.IStudentService;
import com.c0821H1.service.student.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ServletBook", value = "/books")
public class ServletBook extends HttpServlet {
    private IBookService bookService = new BookService();
    private IStudentService studentService = new StudentService();
    private ICardService cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showBorrowBook(request, response);
                break;
            case "listBorrow":
                showListBorrow(request, response);
                break;
            case "return":
                returnBook(request,response);
                break;
            case "list":
            default:
                showListBook(request, response);
                break;
        }

    }

    private void showListBorrow(HttpServletRequest request, HttpServletResponse response) {
        List<BookCard> bookCardList = cardService.findAllBorrow();
        request.setAttribute("borrowList", bookCardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/cardBorrow.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBorrowBook(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.select(idBook);
        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList", studentList);
        request.setAttribute("book", book);
        Date borrowDate = Date.valueOf(LocalDate.now());
        request.setAttribute("BorrowDate", borrowDate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/borrow.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) {
       List<Book> bookList = bookService.findAll();
       request.setAttribute("bookList", bookList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/books.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                borrowBook(request, response);
                break;
            case "return":
                returnBook(request,response);
                break;
            case "list":
            default:
                showListBook(request, response);
                break;
        }
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        BookCard bookCard = cardService.selectCode(id);
        int idBook = bookCard.getIdBook();
        Book book = bookService.select(idBook);
        int quantity = bookService.select(idBook).getQuantity() +1;
        book.setQuantity(quantity);
        bookService.update(book);
        cardService.updateTrue(bookCard);
        try {
            response.sendRedirect("/books");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String idCard = request.getParameter("mms");
        String nameBook = request.getParameter("nameBook");
        Date dateBorrow = Date.valueOf(request.getParameter("borrowDate"));
        Date dateReturn = Date.valueOf(request.getParameter("payDate"));
        int idStudent = Integer.parseInt(request.getParameter("IDstudent"));
        BookCard bookCard = new BookCard(idCard, idBook, idStudent, true, dateBorrow, dateReturn);
        int quantity = bookService.select(idBook).getQuantity()-1;
        if (quantity > 0) {
            Book newBook = bookService.select(idBook);
            newBook.setQuantity(quantity);
            bookService.update(newBook);
            cardService.insert(bookCard);
            try {
                response.sendRedirect("/books");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        }

    }
}
