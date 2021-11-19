package com.c0821H1.service.book;

import com.c0821H1.model.Book;
import com.c0821H1.service.IService;

public interface IBookService extends IService<Book> {
    Book selectByName(String name);
}
