package com.dinesh.sealedclasses.book;

/**
 * This class can be extended by another classes and can be override
 * abstract classses.
 */
public non-sealed class Poetry extends Book {

    private String GENRE_POETRY = "Poetry";

    public Poetry(String title, String author, String ISBN){
        super(title, author, ISBN);
    }

    @Override
    public String getGenre() {
        return GENRE_POETRY;
    }
}
