package elasticsearch;

import com.google.inject.Singleton;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Singleton
public class ElasticConnectionFactory {

    Client client;

    public Client getClient(String hostName, String clusterName , int port, int timeout) throws UnknownHostException {

        if(!(null == client)) return client;

        System.out.println("clusterName : " + clusterName);

        System.setProperty("es.set.netty.runtime.available.processors", "false");
        String t = ( timeout / 1000 ) + "s";
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.ping_timeout", t)
                .build();
         client = new PreBuiltTransportClient(settings)
                 .addTransportAddress(new TransportAddress(InetAddress.getByName(hostName),port));


        return client;
    }
}
