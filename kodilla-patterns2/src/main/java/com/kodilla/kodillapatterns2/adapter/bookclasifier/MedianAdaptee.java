package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookFromLibB;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    private Statistics statistics;

    @Override
    public int averagePublicationYear(Map<BookSignature, BookFromLibB> books) {
        statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, BookFromLibB> books) {
        statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }

}
