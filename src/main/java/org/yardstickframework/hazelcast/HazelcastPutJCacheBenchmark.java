package org.yardstickframework.hazelcast;

import java.util.Map;

/**
 * Hazelcast benchmark that performs put operations.
 */
public class HazelcastPutJCacheBenchmark extends HazelcastAbstractJCacheBenchmark {
    /** */
    public HazelcastPutJCacheBenchmark() {
        super("jcache");
    }

    /** {@inheritDoc} */
    @Override public boolean test(Map<Object, Object> ctx) throws Exception {
        int key = nextRandom(args.range());

        cache.put(key, new SampleValue(key));

        return true;
    }
}