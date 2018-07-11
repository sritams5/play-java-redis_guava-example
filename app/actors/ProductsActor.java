package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import elasticsearch.ESConnectionFactory;
import elasticsearch.ElasticConnectionFactory;
import elasticsearch.Product;
import elasticsearch.QueryUtil;
import org.elasticsearch.client.Client;
import services.RedisCluster;


import javax.inject.Inject;
import java.util.List;

public class ProductsActor extends AbstractActor {

    @Inject
    private RedisCluster redisService;

    public ProductsActor() {
        System.out.println("Akka Product Actor");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, msg -> {
            String responseStr = "";
            Client client = ESConnectionFactory.getClient("localhost", "elasticsearch",
                    9300, 30000);
            List<Product> response = QueryUtil.getData(client, msg);

            if (!response.isEmpty()) {
                responseStr = response.toString();
            }
            sender().tell(responseStr, ActorRef.noSender());

        }).build();
    }
}
