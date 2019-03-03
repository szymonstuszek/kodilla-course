package com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, BookFromLibB> books);
    int medianPublicationYear(Map<BookSignature, BookFromLibB> books);
}
