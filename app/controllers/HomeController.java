package controllers;

import com.google.gson.Gson;
import elasticsearch.ElasticConnectionFactory;
import elasticsearch.Product;
import elasticsearch.QueryUtil;
import org.elasticsearch.client.Client;
import play.mvc.*;

import services.CacheService;
import services.RedisCluster;
import views.html.*;

import javax.inject.Inject;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    RedisCluster redisService;

    @Inject
    CacheService cacheService;

    @Inject
    ElasticConnectionFactory elasticConnectionFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index(String agent) {
        String content = "";
        try {
            content = "Content : " + cacheService.get(agent);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ok(content);
    }

    //Exercise
    public Result products(String prd) throws UnknownHostException, InterruptedException, ExecutionException {

        String cachePrd = redisService.getAsyncCommands().get(prd).get();

        if (!(null == cachePrd)) {
            System.out.println("From redis");
            return ok(cachePrd);
        }

        Client client = elasticConnectionFactory.getClient("localhost", "elasticsearch",
                9300, 30000);

        List<Product> response = QueryUtil.getData(client, prd);

        if (!response.isEmpty()) {

            redisService.getAsyncCommands().set(prd, response.toString());

            return ok(response.toString());
        }

        return ok("No data");

    }


    public Result stats() {
        String stats = "";
        stats = cacheService.stats();
        return ok(stats);
    }

}
