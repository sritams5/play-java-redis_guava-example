package elasticsearch;

import com.google.gson.Gson;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryUtil {


    public static List<Product> getData(Client client, String name) {
        List<Product> prdList = new ArrayList<>();
        System.out.println("Product name : " + name + "\n");
        BoolQueryBuilder qb = new BoolQueryBuilder().should((QueryBuilders.termQuery("name", name)));
        SearchResponse searchResponse = client.prepareSearch("product").setTypes("_doc").setQuery(qb).execute().actionGet();

        if (searchResponse.getHits().getHits().length > 0) {
            for (SearchHit data : searchResponse.getHits().getHits()) {

                Product product = new Gson().fromJson(data.getSourceAsString(), Product.class);
                prdList.add(product);
            }
        }

        return prdList;
    }
}
