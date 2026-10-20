package com.example.demo;

import com.example.demo.controller.BookController;
import com.example.demo.dto.BookRequestDto;
import com.example.demo.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Включаем поддержку Mockito в JUnit 5
class BookControllerTest {

    @Mock
    private BookService bookService; // Создаем фейковый сервис

    @InjectMocks
    private BookController bookController; // Внедряем фейковый сервис в контроллер

    @BeforeEach
    void setUp() {
        System.out.println("--- Запуск теста ---");
    }

    @AfterEach
    void tearDown() {
        System.out.println("--- Тест завершен ---");
    }

    @Test
    void shouldGetAllBooks() {
        // Подготовка данных
        List<BookService.BookDto> mockBooks = List.of(
                new BookService.BookDto(1L, "Java 25", "Oracle")
        );

        // Настраиваем поведение мока: когда вызовут getAllBooks(), вернуть mockBooks
        when(bookService.getAllBooks()).thenReturn(mockBooks);

        // Вызов метода контроллера
        List<BookService.BookDto> result = bookController.getAllBooks();

        // Проверки (assertEquals)
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Java 25", result.get(0).title());

        // Проверяем, что метод у сервиса действительно вызывался ровно 1 раз
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    void shouldCreateBook() {
        // Подготовка
        BookRequestDto requestDto = new BookRequestDto("Spring Boot", "Craig Walls");
        BookService.BookDto savedBook = new BookService.BookDto(1L, "Spring Boot", "Craig Walls");

        when(bookService.createBook(requestDto)).thenReturn(savedBook);

        // Вызов
        ResponseEntity<BookService.BookDto> response = bookController.createBook(requestDto);

        // Проверки
        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
        assertEquals("Spring Boot", response.getBody().title());
    }
}