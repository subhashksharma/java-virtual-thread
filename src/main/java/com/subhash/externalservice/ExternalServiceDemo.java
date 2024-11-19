package com.subhash.externalservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExternalServiceDemo {

    public static  final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceDemo.class);

    public static void main(String[] args) {

        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

           Future<?> future =  executorService.submit(()->Client.getProduct(1));

           LOGGER.info("Product info :  {}", future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
