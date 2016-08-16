/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apiman.plugins.cache_policy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test.
 *
 * @author eric.wittmann@redhat.com
 */
@SuppressWarnings({ "nls" })
public class CachePolicyConfigTest {

    /**
     * Test method for {@link io.apiman.gateway.engine.policies.CachePolicy#parseConfiguration(java.lang.String)}.
     */
    @Test
    public void testParseConfiguration() {
        CachePolicy policy = new CachePolicy();

        // Empty config test
        String config = "{}";
        Object parsed = policy.parseConfiguration(config);
        Assert.assertNotNull(parsed);
        Assert.assertEquals(CacheConfig.class, parsed.getClass());
        CacheConfig parsedConfig = (CacheConfig) parsed;
        Assert.assertEquals(0, parsedConfig.getTtl());

        // Sample real config
        config = "{\n" +
                "  \"ttl\" : 12345\n" +
                "}";

        parsed = policy.parseConfiguration(config);
        parsedConfig = (CacheConfig) parsed;
        Assert.assertEquals(12345L, parsedConfig.getTtl());
    }

}
