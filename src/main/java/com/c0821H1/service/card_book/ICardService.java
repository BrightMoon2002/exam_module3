package com.c0821H1.service.card_book;

import com.c0821H1.model.BookCard;
import com.c0821H1.service.IService;

import java.util.List;

public interface ICardService extends IService<BookCard> {
    List<BookCard> findAllBorrow();
    boolean updateTrue(BookCard bookCard);
    BookCard selectCode(String code);
}
