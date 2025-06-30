package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // ✅ Setter method required for XML-based DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBookTitle() {
        System.out.println("Book: " + bookRepository.getBookTitle());
    }
}
