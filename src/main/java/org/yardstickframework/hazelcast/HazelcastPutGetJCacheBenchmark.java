package org.yardstickframework.hazelcast;

import java.util.Map;

/**
 * Hazelcast benchmark that performs put and get operations.
 */
public class HazelcastPutGetJCacheBenchmark extends HazelcastAbstractJCacheBenchmark {
    /** */
    public HazelcastPutGetJCacheBenchmark() {
        super("jcache");
    }

    /** {@inheritDoc} */
    @Override public boolean test(Map<Object, Object> ctx) throws Exception {
        int key = nextRandom(args.range());

        Object val = cache.get(key);

        if (val != null)
            key = nextRandom(args.range());

        cache.put(key, new SampleValue(key));

        return true;
    }
}