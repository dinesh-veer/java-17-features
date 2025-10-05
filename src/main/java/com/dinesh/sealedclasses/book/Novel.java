package com.dinesh.sealedclasses.book;

/**
 * This is final class not allowed to extend.
 */
public final class Novel extends Book{

    private final String GENRE_NOVEL ="Novel";

    public Novel(String title, String author, String ISBN){
        super(title, author, ISBN);
    }

    @Override
    public String getGenre() {
        return GENRE_NOVEL;
    }
}
