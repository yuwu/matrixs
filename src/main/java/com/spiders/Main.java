package com.spiders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String args[]) throws Exception {

        Document doc = Jsoup.connect("https://www.dy2018.com/i/99266.html").get();

        System.out.print(doc.body());
    }
}
