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
public class TrapezoidalRuleTest {

    private final int iterations;

    private final DefiniteIntegral integral;

    private final double actual;

    private TrapezoidalRule trapezoidalRule;

    public TrapezoidalRuleTest(int iterations, DefiniteIntegral integral, double actual) {
        this.iterations = iterations;
        this.integral = integral;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {100, new DefiniteIntegral(x -> 1 / (x + 1), 2, 3), 0.2876831d},
                {3600, new DefiniteIntegral(x -> x * (x - 2) * (x - 3), 0, 5), 22.9166667}
        });
    }

    @Before
    public void setUp() {
        this.trapezoidalRule = new TrapezoidalRule(iterations);
    }

    @Test
    public void testSolve() {
        double expected = this.trapezoidalRule.solve(integral);
        assertEquals(expected, actual, 1e-5);
    }
}