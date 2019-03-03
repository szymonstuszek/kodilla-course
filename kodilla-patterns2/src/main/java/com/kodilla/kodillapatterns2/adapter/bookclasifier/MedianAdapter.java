package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.BookFromLibA;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookFromLibB;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<BookFromLibA> bookSet) {
        Map<BookSignature, BookFromLibB> bookMap = new HashMap<>();

        for(BookFromLibA bookFromLibA : bookSet) {
            String signature = bookFromLibA.getSignature();
            BookSignature bookSignature = new BookSignature(signature);

            BookFromLibB convertedBook = new BookFromLibB(
                    bookFromLibA.getAuthor(),
                    bookFromLibA.getTitle(),
                    bookFromLibA.getPublicationYear()
            );

            bookMap.put(bookSignature, convertedBook);
        }

        return medianPublicationYear(bookMap);
    }
}
