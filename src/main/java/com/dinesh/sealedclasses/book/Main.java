package com.dinesh.sealedclasses.book;

public class Main {

    public static void main(String[] args) {

        System.out.println("-------------------------------------------------------");
        Fiction fiction = new Fiction("Fiction","Tommy", "ABABBA");

        System.out.println("Type of book for Fiction Object : "+ fiction.getGenre());

        System.out.println("--------------------------------------------------------");

        Novel novel = new Novel("Novel","Jack", "NNNNNNNN");
        System.out.println("Type of book for Novel Object : "+ novel.getGenre());
        System.out.println("--------------------------------------------------------");

        Poetry poetry = new Poetry("Poetry", "Meloni","PPPPPPP");
        System.out.println("Type of book for Poetry Object : "+ poetry.getGenre());

        System.out.println("--------------------------------------------------------");

        OuterSealedExtension outer = new OuterSealedExtension("OuterSealedExtension","HHHHH", "OOOOOO");
        System.out.println("Type of book for OuterSealedExtension Object : "+ outer.getGenre());
        System.out.println("--------------------------------------------------------");
    }

}
