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
public class SimpsonsRuleExceptionTest {

    @Test(expected = NullPointerException.class)
    public void testCreateAnInvalidObject() {
        new SimpsonsRule(100, null);
    }

    @Test(expected = ArithmeticException.class)
    public void testInvalidIterationNumber1() {
        new SimpsonsRule(100, SimpsonsRule.Composite.THREE_EIGHTHS);
    }

    @Test(expected = ArithmeticException.class)
    public void testInvalidIterationNumber2() {
        new SimpsonsRule(3);
    }

    @Test(expected = ArithmeticException.class)
    public void testInvalidIterationNumber3() {
        SimpsonsRule simpsonsRule = new SimpsonsRule(100);
        simpsonsRule.setIterations(37);
    }

}
