/*
 * Copyright 2017 Gustavo Pacheco.
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

package com.ryctabo.simlib.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Test cases for the <strong>MathUtils</strong> class in the plus methods.
 *
 * @author Gustavo Pacheco
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class MathUtilsPlusTest {

    /**
     * Expected value.
     */
    private final long expected;

    /**
     * Array of values to plus.
     */
    private final long[] values;

    /**
     * Create a new object.
     *
     * @param expected expected value
     * @param values   array of values to plus
     */
    public MathUtilsPlusTest(long expected, long[] values) {
        this.expected = expected;
        this.values = values;
    }

    /**
     * This method run several tests with different values.
     *
     * @return parameters.
     */
    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {0, new long[0]},
                {6, new long[]{3, 2, 1}},
                {-1, new long[]{3, 2, -6}},
                {15, new long[]{8, 2, 4, 1}}
        });
    }

    /**
     * Test sum method.
     *
     * @see MathUtils#plus(long...)
     */
    @Test
    public void test() {
        Assert.assertEquals(expected, MathUtils.plus(values));
    }
}
