package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        // Given
        Library library = new Library("Main Library");

        IntStream.rangeClosed(1, 5)
                .forEach(i -> library.addBook(new Book("Title" + i, "Author" + i, LocalDate.now().minusYears(i))));

        // When
        Library shallowCopy = library.clone();
        Library deepCopy = library.clone();

        // Then
        assertEquals(library.getBooks(), shallowCopy.getBooks());
        assertEquals(library.getBooks(), deepCopy.getBooks());
    }
}
