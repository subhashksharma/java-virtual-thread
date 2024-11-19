package com.subhash.aggregator;

import com.subhash.externalservice.Client;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class AggregatorService {

    static ExecutorService executorService;
   public AggregatorService(ExecutorService executorService) {
       this.executorService = executorService;
   }



   public ProductDto getProductDto(int id) throws ExecutionException, InterruptedException {

       var future =  executorService.submit(()->Client.getProduct(1));
       var future1 =  executorService.submit(()->Client.getRating(1));

        return new ProductDto(id,  future.get(), future1.get());
   }

}
