package com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb;

public class BookFromLibB {
    private final String author;
    private final String title;
    private final int yearOfPublication;

    public BookFromLibB(final String author, final String title, final int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
