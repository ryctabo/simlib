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

import com.ryctabo.simlib.nm.SimpsonsRule.Composite;
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
public class SimpsonsRuleTest {

    private final int iterations;

    private final Composite composite;

    private final DefiniteIntegral integral;

    private final double actual;

    private SimpsonsRule rule;

    public SimpsonsRuleTest(int iterations, Composite composite,
                            DefiniteIntegral integral, double actual) {
        this.iterations = iterations;
        this.composite = composite;
        this.integral = integral;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {4, Composite.MAIN, new DefiniteIntegral(x -> 1 / (x + 1), 2, 3), 0.2876831d},
                {12, Composite.THREE_EIGHTHS, new DefiniteIntegral(x -> x * (x - 2) * (x - 3), 0, 5), 22.9166667}
        });
    }

    @Before
    public void setUp() {
        this.rule = new SimpsonsRule(iterations, composite);
    }

    @Test
    public void testSetIteration() {
        this.rule.setIterations(iterations);
        assertEquals(this.rule.getIterations(), iterations);
    }

    @Test
    public void testSolve() {
        assertEquals(this.rule.solve(integral), actual, 1e-7);
    }

    @Test
    public void testGetComposite() {
        assertEquals(this.rule.getComposite(), composite);
    }
}
