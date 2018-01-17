package org.yardstickframework.hazelcast;

import java.util.Map;

/**
 * Hazelcast benchmark that performs get operations.
 */
public class HazelcastGetJCacheBenchmark extends HazelcastAbstractJCacheBenchmark {
    /** */
    public HazelcastGetJCacheBenchmark() {
        super("jcache");
    }

    /** {@inheritDoc} */
    @Override public boolean test(Map<Object, Object> ctx) throws Exception {
        int key = nextRandom(args.range());

        cache.get(key);

        return true;
    }
}