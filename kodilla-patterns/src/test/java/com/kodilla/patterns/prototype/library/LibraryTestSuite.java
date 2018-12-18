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
                LocalDate.of(1995, 3, 15));
        Book book3 = new Book("How to write a book",
                "John Doe",
                LocalDate.of(2000, 5, 3));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //When
        int countOfRetrievedBooks = library.getBooks().size();

        //Then
        Assert.assertEquals(3, countOfRetrievedBooks);
    }

    @Test
    public void testLibraryShallowCopy() {
        //Given
        Library library = new Library("Public library");

        Book book1 = new Book("Adventures of Robin Hood",
                "John Smith",
                LocalDate.of(1990, 1, 22));
        Book book2 = new Book("Mathematical Analysis",
                "Albert Enstein",
                LocalDate.of(1995, 3, 15));
        Book book3 = new Book("How to write a book",
                "John Doe",
                LocalDate.of(2000, 5, 3));
        Book book4 = new Book("Wall Street Journal",
                "Unknown",
                LocalDate.of(2004, 11, 30));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //create a shallow copy of the library
        //adding a book in the original library should add the book to the clone
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.getBooks().add(book4);
        int countOfBooksInOriginalLibrary = library.getBooks().size();
        int countOfBooksInClonedLibrary = clonedLibrary.getBooks().size();

        //Then
        Assert.assertEquals(4, countOfBooksInOriginalLibrary);
        Assert.assertEquals(4, countOfBooksInClonedLibrary);
        Assert.assertEquals(countOfBooksInOriginalLibrary, countOfBooksInClonedLibrary);
    }

    @Test
    public void testLibraryDeepCopy() {
        //Given
        Library library = new Library("Public library");

        Book book1 = new Book("Adventures of Robin Hood",
                "John Smith",
                LocalDate.of(1990, 1, 22));
        Book book2 = new Book("Mathematical Analysis",
                "Albert Enstein",
                LocalDate.of(1995, 3, 15));
        Book book3 = new Book("How to write a book",
                "John Doe",
                LocalDate.of(2000, 5, 3));
        Book book4 = new Book("Wall Street Journal",
                "Unknown",
                LocalDate.of(2004, 11, 30));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //create a deep copy of the library
        //adding a book in the original library should not add the book to the clone
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.getBooks().add(book4);
        int countOfBooksInOriginalLibrary = library.getBooks().size();
        int countOfBooksInClonedLibrary = clonedLibrary.getBooks().size();

        //Then
        Assert.assertEquals(4, countOfBooksInOriginalLibrary);
        Assert.assertEquals(3, countOfBooksInClonedLibrary);
        Assert.assertNotEquals(countOfBooksInOriginalLibrary, countOfBooksInClonedLibrary);
    }
}
