package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.BookFromLibA;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter adapter = new MedianAdapter();

        BookFromLibA book1 = new BookFromLibA("test author", "test title", 2000, "1234");
        BookFromLibA book2 = new BookFromLibA("test author", "test title", 2004, "1234");
        BookFromLibA book3 = new BookFromLibA("test author", "test title", 2004, "1234");
        BookFromLibA book4 = new BookFromLibA("test author", "test title", 2010, "1234");
        BookFromLibA book5 = new BookFromLibA("test author", "test title", 2018, "1234");
        BookFromLibA book6 = new BookFromLibA("test author", "test title", 2001, "1234");

        Set<BookFromLibA> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);

        //When
        int median = adapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2004 ,median);
    }
}
