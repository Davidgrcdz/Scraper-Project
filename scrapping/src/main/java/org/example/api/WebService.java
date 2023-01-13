package org.example.api;

import com.google.gson.Gson;
import org.example.model.Hotel;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

import static org.example.scrapper.BookingScrapper.hotels;
import static spark.Spark.get;
import static spark.Spark.halt;

public class WebService implements ApiServer{
    public void start() {
        get("/hotels", WebService::getHotels);
        get("/hotels/:name/services", WebService::getServices);
        get("/hotels/:name/comments", WebService::getComments);
        get("/hotels/:name", WebService::getLocation);
        get("/hotels/:name/ratings", WebService::getRatings);
    }

    private static String getHotels(Request request, Response response) {
        response.header("content-type", "application/json");
        List<String> hotelnames = new ArrayList<>();
        for (Hotel hotel : hotels) hotelnames.add(hotel.getName());
        return toJson(hotelnames);
    }

    private static String getServices(Request request, Response response) {
        response.header("content-type", "application/json");
        String name = request.params("name");
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) return toJson(hotel.getServices());
        }
        halt(404, "Hotel not found");
        return "";
    }

    private static String getLocation(Request request, Response response) {
        response.header("content-type", "application/json");
        String name = request.params("name");
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) return toJson(hotel.getLocation());
        }
        halt(404, "Hotel not found");
        return "";
    }

    private static String getComments(Request request, Response response) {
        response.header("content-type", "application/json");
        String name = request.params("name");
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) return toJson(hotel.getComments());
        }
        halt(404, "Hotel not found");
        return "";
    }

    private static String getRatings(Request request, Response response) {
        response.header("content-type", "application/json");
        String name = request.params("name");
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) return toJson(hotel.getRatings());
        }
        halt(404, "Hotel not found");
        return "";
    }



    private static String toJson(Object o) {
        return new Gson().toJson(o);
    }
}
