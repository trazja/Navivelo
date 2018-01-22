package com.example.tryhu.navivelo;


public class Items {

    private String name;


    public static final Items[] items = {
            new Items("uwaga na samochody"),
            new Items("uwaga na pieszych"),
            new Items("uwaga na pociąg/tramwaj"),
            new Items("zjazd na jezdnię"),
            new Items("zjazd na lewy pas do skrętu w lewo"),
            new Items("stromy zjazd/wjazd"),
            new Items("wąski przejazd"),
            new Items("zjazd na trasę po drugiej stronie jezdni"),
            new Items("słaba widoczność"),
            new Items("kierunkowa sygnalizacja dla rowerów"),


    };


    private Items(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}

