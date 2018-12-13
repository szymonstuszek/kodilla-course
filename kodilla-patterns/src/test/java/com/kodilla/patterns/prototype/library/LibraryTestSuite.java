package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Public library");

        Book book1 = new Book("Adventures of Robin Hood",
                "John Smith",
                LocalDate.of(1990, 1, 22));
        Book book2 = new Book("Mathematical Analysis",
                "Albert Enstein",
                LocalDate.of(1990, 3, 15));
        Book book3 = new Book("How to write a book",
                "John Doe",
                LocalDate.of(1990, 5, 3));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //When
        int countOfRetrievedBooks = library.getBooks().size();

        //Then
        Assert.assertEquals(3, countOfRetrievedBooks);
    }
}
