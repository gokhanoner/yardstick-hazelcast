package org.yardstickframework.hazelcast;

import com.hazelcast.config.CacheConfig;
import com.hazelcast.core.HazelcastInstance;
import org.yardstickframework.BenchmarkConfiguration;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheManager;

/**
 * Hazelcast benchmark that performs get operations.
 */
public abstract class HazelcastAbstractJCacheBenchmark extends HazelcastAbstractBenchmark {

    private String jCacheName;
    protected Cache<Object, Object> cache;

    public HazelcastAbstractJCacheBenchmark(String jCacheName) {
        super(jCacheName);
        this.jCacheName = jCacheName;
    }

    @Override public void setUp(BenchmarkConfiguration cfg) throws Exception {
        super.setUp(cfg);

        HazelcastInstance hazelcast = this.hazelcast();
        CacheManager cacheManager = getCacheManager(hazelcast);

        CacheConfig config = new CacheConfig();
        config.setName(jCacheName);

        try {
            cacheManager.createCache(jCacheName, config);
        } catch (CacheException e) {}

        cache = cacheManager.getCache(jCacheName);
    }


    /** {@inheritDoc} */
    @Override public void tearDown() throws Exception {
        cache.clear();
        super.tearDown();
    }
}
