package com.example.demo.service;

import com.example.demo.dto.BookRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final List<BookDto> books = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public record BookDto(Long id, String title, String author) {}

    public List<BookDto> getAllBooks() {
        return books;
    }

    public BookDto createBook(BookRequestDto dto) {
        Long id = counter.getAndIncrement();
        BookDto book = new BookDto(id, dto.title(), dto.author());
        books.add(book);
        return book;
    }
}

