package controllers;

import actors.ProductsActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import play.mvc.*;
import services.RedisCluster;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static akka.pattern.PatternsCS.ask;

public class ProductsController extends Controller {

    @Inject
    private RedisCluster redisService;

    private ActorSystem system = ActorSystem.create("Products");
    private ActorRef actorRef = system.actorOf((Props.create(ProductsActor.class)), "productActor");

    /**
     * Get Products from Redis or Elastic
     *
     * @param productName
     * @return
     */
    public CompletionStage<Result> getProducts(String productName) throws ExecutionException, InterruptedException {
        System.out.println("Redis : " + redisService);
        String cachePrd = redisService.getAsyncCommands().get(productName).get();

        if (!(null == cachePrd)) {
            CompletableFuture future = new CompletableFuture();
            future.complete(ok("From Redis : " + cachePrd));
            return future;
        }

        CompletionStage<Object> msg = ask(actorRef, productName, 30000);
        return msg.thenApply(response -> {
            if ("".equals(response.toString())) {
                response = "No data for : " + productName;
            }else{
                redisService.getAsyncCommands().setex(productName, 10, response.toString());
            }
            return ok("From ElasticSearch : " + response);
        });
    }
}
