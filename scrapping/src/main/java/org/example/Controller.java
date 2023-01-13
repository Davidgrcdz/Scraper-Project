package org.example;

import org.example.api.ApiServer;
import org.example.api.WebService;
import org.example.scrapper.BookingScrapper;
import org.example.scrapper.Scrapper;


public class Controller {
    private final Scrapper bookingScrapper;
    private final ApiServer webService;

    public Controller() {
        bookingScrapper = new BookingScrapper();
        webService = new WebService();
    }

    public void run(int nPages, String urlWithoutOffset) {
        bookingScrapper.scrapper(nPages, urlWithoutOffset);
        webService.start();
    }

}
