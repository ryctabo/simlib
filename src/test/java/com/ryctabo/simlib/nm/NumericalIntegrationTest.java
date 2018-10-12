/*
 * Copyright 2018 Gustavo Pacheco.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ryctabo.simlib.nm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@RunWith(Parameterized.class)
public class NumericalIntegrationTest {

    private final int iterations;

    private final double lowerLimit;

    private final double upperLimit;

    private final double actual;

    public NumericalIntegrationTest(int iterations, double lowerLimit,
                                    double upperLimit, double actual) {
        this.iterations = iterations;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {10, 0d, 0.8d, 0.08d},
                {200, 2d, 4d, 0.01d},
                {50, 1d, 8d, 0.14d}
        });
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testCalculateStepSize() {
        NumericalIntegration ni = new NumericalIntegration(this.iterations) {
            @Override
            protected double solveImplementation(DefiniteIntegral di) {
                return 0d;
            }
        };
        ni.solve(new DefiniteIntegral(null, lowerLimit, upperLimit));
        assertEquals(ni.getStepSize(), actual, 0d);
    }
}
