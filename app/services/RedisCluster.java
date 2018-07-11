package services;

import com.lambdaworks.redis.ReadFrom;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.async.RedisAsyncCommands;
import com.lambdaworks.redis.cluster.RedisClusterClient;
import com.lambdaworks.redis.cluster.api.StatefulRedisClusterConnection;
import com.lambdaworks.redis.cluster.api.async.RedisAdvancedClusterAsyncCommands;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created By : Mazhar
 */

@Singleton
public class RedisCluster {

//    private List<RedisURI> uri;
    private RedisURI uri;

    /*RedisClusterClient client;
    private RedisAdvancedClusterAsyncCommands<String, String> asyncCommands;
    private StatefulRedisClusterConnection<String, String> connection;*/

    private RedisClient client;
    private RedisAsyncCommands<String, String> asyncCommands;
    private StatefulRedisConnection<String, String> connection;


    public RedisCluster() {
        this.uri =  RedisURI.Builder.redis("localhost").withPort(6379).build();

        /*this.uri = new ArrayList<RedisURI>();
        uri.add(RedisURI.Builder.redis("localhost").withPort(7076).build());
        uri.add(RedisURI.Builder.redis("localhost").withPort(7077).build());
        uri.add(RedisURI.Builder.redis("localhost").withPort(7078).build());*/

//        this.client = RedisClusterClient.create(uri);

        this.client = RedisClient.create(uri);

        this.connection = client.connect();
//        this.connection.setReadFrom(ReadFrom.MASTER);
        this.asyncCommands =  connection.async();
    }

    public String test(String agent){
        String content = "not found";
        try {
            if("".equalsIgnoreCase(agent) || "MOBILE".equalsIgnoreCase(agent)) {
                if("MOBILE".equalsIgnoreCase(agent)){
                    content = asyncCommands.get("mobile_content").get();
                }else {
                    content = asyncCommands.get("desktop_content").get();
                }
            }else {
                content = asyncCommands.get(agent).get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return content;
    }

    public RedisAsyncCommands<String, String> getAsyncCommands() {
        return asyncCommands;
    }
}
