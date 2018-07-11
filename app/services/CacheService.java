package services;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ExecutionException;

/**
 * Created By : Mazhar
 */

@Singleton
public class CacheService {

    @Inject
    private RedisCluster redisService;

    private CacheLoader<String, String> loader;
    private LoadingCache<String, String> cache;

    public CacheService() {
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return redisService.test(key);
            }
        };

        cache = CacheBuilder.newBuilder().maximumSize(3).recordStats().build(loader);

    }

    public String get(String key) throws ExecutionException {
        return cache.get(key);
    }

    public String stats(){
        String stats = "";
        stats = stats + "Hit Count : " + cache.stats().hitCount();
        stats = stats + "\nMiss Count : " + cache.stats().missCount();


        return stats;
    }



}
