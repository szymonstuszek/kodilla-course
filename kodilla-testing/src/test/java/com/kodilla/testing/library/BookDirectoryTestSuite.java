package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    @Test
    public void testListBooksInHandsOfWhenNoBooks() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser testUser = new LibraryUser("John", "Smith", "123456789");

        List<Book> listOfBooksBorrowedByTestUser = new ArrayList<>();

        when(libraryDatabaseMock.listBooksInHandsOf(testUser))
                .thenReturn(listOfBooksBorrowedByTestUser);

        //When
        List<Book> listOfBooks = bookLibrary.listBooksInHandsOf(testUser);

        //Then
        assertEquals(0, listOfBooks.size());
    }

    @Test
    public void testListBooksInHandsOfWith1BookBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser testUser = new LibraryUser("John", "Smith", "123456789");
        Book book = new Book("The new Book", "Michael John", 1999);

        List<Book> listOfBooksBorrowedByTestUser = new ArrayList<>();
        listOfBooksBorrowedByTestUser.add(book);

        when(libraryDatabaseMock.listBooksInHandsOf(testUser))
                .thenReturn(listOfBooksBorrowedByTestUser);

        //When
        List<Book> listOfBooks = bookLibrary.listBooksInHandsOf(testUser);

        //Then
        assertEquals(1, listOfBooks.size());
    }

    @Test
    public void testListBooksInHandsOfWith5BooksBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser testUser = new LibraryUser("John", "Smith", "123456789");
        Book book = new Book("The new Book", "Michael John", 1999);

        List<Book> listOfBooksBorrowedByTestUser = new ArrayList<>();
        listOfBooksBorrowedByTestUser.add(book);
        listOfBooksBorrowedByTestUser.add(book);
        listOfBooksBorrowedByTestUser.add(book);
        listOfBooksBorrowedByTestUser.add(book);
        listOfBooksBorrowedByTestUser.add(book);

        when(libraryDatabaseMock.listBooksInHandsOf(testUser))
                .thenReturn(listOfBooksBorrowedByTestUser);

        //When
        List<Book> listOfBooks = bookLibrary.listBooksInHandsOf(testUser);

        //Then
        assertEquals(5, listOfBooks.size());
    }


    @Test
    public void testListBooksWithConditionsReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
            .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
            .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
            .thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);

        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
            .thenReturn(resultListOf10Books);

        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0))
                .listBooksWithCondition(anyString());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n,"Author " + n,
                    1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
