package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record BookRequestDto(
        @NotBlank(message = "Title cannot be blank")
        String title,

        @NotBlank(message = "Author cannot be blank")
        String author
) {}

