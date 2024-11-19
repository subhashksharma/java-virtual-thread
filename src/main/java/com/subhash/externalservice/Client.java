package com.subhash.externalservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

public class Client {

    public static final String PRODUCT_URL = "http://localhost:7070/sec01/product/%d";

    public static String getProduct(int productId) throws MalformedURLException {

        return getByte(productId);
    }

    public static String getRating(int ratingId) throws MalformedURLException {

        return getByte(ratingId);
    }

    private static String getByte(int id) {
        try(InputStream stream = URI.create(PRODUCT_URL.formatted(id)).toURL().openStream()) {
            return new String(stream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
