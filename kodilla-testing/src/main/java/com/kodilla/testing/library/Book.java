package com.kodilla.testing.library;

import java.util.Objects;

public class Book {
    String title;
    String author;
    int publicatioYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicatioYear == book.publicatioYear && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicatioYear);
    }

    public Book(String title, String author, int publicatioYear) {
        this.title = title;
        this.author = author;
        this.publicatioYear = publicatioYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicatioYear() {
        return publicatioYear;
    }

    public void setPublicatioYear(int publicatioYear) {
        this.publicatioYear = publicatioYear;
    }
}
