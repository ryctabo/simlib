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

import org.junit.Test;

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

}
