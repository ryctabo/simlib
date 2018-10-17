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

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public class DefiniteIntegralTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAnInvalidIntegral() {
        new DefiniteIntegral(null, 3, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAnInvalidIntegralInSetMethod1() {
        DefiniteIntegral integral = new DefiniteIntegral(null, 1, 2);
        integral.setLowerLimit(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAnInvalidIntegralInSetMethod2() {
        DefiniteIntegral integral = new DefiniteIntegral(null, 1, 2);
        integral.setUpperLimit(0);
    }

    @Test
    public void testSetInterval() {
        DefiniteIntegral integral = new DefiniteIntegral(null, 0, 1);
        assertEquals(integral.getLowerLimit(), 0, 0d);
        assertEquals(integral.getUpperLimit(), 1, 0d);

        integral.setInterval(1, 2);

        assertEquals(integral.getLowerLimit(), 1, 0d);
        assertEquals(integral.getUpperLimit(), 2, 0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAnInvalidIntegralInSetMethod3() {
        DefiniteIntegral integral = new DefiniteIntegral(null, 1, 2);
        integral.setInterval(1, 0);
    }

}
