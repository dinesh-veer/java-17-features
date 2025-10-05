package com.dinesh.sealedclasses.book;

public class OuterSealedExtension extends Poetry{

    private final String OUTER_SEALED_EXTENSION = "OuterSealedExtension";

    public OuterSealedExtension(String author, String title, String ISBN) {
        super(author, title, ISBN);
    }

    @Override
    public String getGenre() {
        return OUTER_SEALED_EXTENSION;
    }
}
