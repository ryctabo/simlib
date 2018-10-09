/*
 *  Copyright 2017 Gustavo Pacheco.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.ryctabo.simlib.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@RunWith(Parameterized.class)
public class MathUtilsPrimeFactorsTest {

    /**
     * Array of expected values.
     */
    private final int[] expected;

    /**
     * Integer value.
     */
    private final int value;

    /**
     * Create a new test object.
     *
     * @param expected array of expected values
     * @param value    integer value
     */
    public MathUtilsPrimeFactorsTest(int[] expected, int value) {
        this.expected = expected;
        this.value = value;
    }

    /**
     * This method run several tests with different values.
     *
     * @return parameters
     */
    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3}, 6},
                {new int[]{2, 2, 5, 5}, 100},
                {new int[]{2, 3, 5, 7}, 210}
        });
    }

    /**
     * Test getPrimeFactors() method.
     *
     * @see MathUtils#getPrimeFactors(int)
     */
    @Test
    public void testGetPrimeFactorsInt() {
        assertArrayEquals(expected, MathUtils.getPrimeFactors(value));
    }

    /**
     * Test getPrimeFactors() method.
     *
     * @see MathUtils#getPrimeFactors(int)
     */
    @Test
    public void testGetPrimeFactorsLong() {
        long[] expected = new long[this.expected.length];
        for (int i = 0; i < this.expected.length; i++)
            expected[i] = (long) this.expected[i];
        assertArrayEquals(expected, MathUtils.getPrimeFactors((long) value));
    }

}
