package com.dinesh.sealedclasses.book;

public sealed abstract class Book permits Fiction, Poetry, Novel {

    protected final String title;
    protected final String author;
    protected final String isbn;
    protected String genre;

    protected Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public abstract String getGenre() ;
}
