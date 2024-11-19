package com.subhash.externalservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

public class Client {

    public static final String PRODUCT_URL = "http://localhost:7070/sec01/product/%d";

    public static String getProduct(int productId) throws MalformedURLException {

        try(InputStream stream = URI.create(PRODUCT_URL.formatted(productId)).toURL().openStream()) {
            return new String(stream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
