package com.subhash.aggregator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AggregatorServiceDemo {


    private static final Logger LOGGER = LoggerFactory.getLogger(AggregatorServiceDemo.class);

    public static void main( String[] args) throws ExecutionException, InterruptedException {

        AggregatorService aggregatorService = new AggregatorService(Executors.newVirtualThreadPerTaskExecutor());
        aggregatorService.getProductDto(1);
        LOGGER.info("Product DTO ::: {}",aggregatorService.getProductDto(1));
    }


}
