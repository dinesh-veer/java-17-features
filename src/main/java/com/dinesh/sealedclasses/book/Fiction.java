package com.dinesh.sealedclasses.book;

/**
 * This class cant extend with other classes
 *
 */
public final class Fiction extends Book {

    private final String GENRE_NOVEL ="Fiction";

    public Fiction(String title, String author, String ISBN) {
        super(title, author, ISBN);
    }

    @Override
    public String getGenre() {
        return GENRE_NOVEL;
    }
}
