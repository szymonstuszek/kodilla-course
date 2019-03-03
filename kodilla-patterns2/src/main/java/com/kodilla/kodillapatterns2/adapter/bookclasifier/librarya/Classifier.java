package com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya;

import java.util.Set;

public interface Classifier {
    int publicationYearMedian(Set<BookFromLibA> bookSet);
}
