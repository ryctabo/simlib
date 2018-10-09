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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.anyLong;
import static org.junit.Assert.*;

/**
 * Test cases for the <strong>MathUtils</strong> class.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MathUtils.class})
public class MathUtilsTest {

    @Test
    public void testAverage() throws Exception {
        //Set up test
        PowerMock.mockStaticPartial(MathUtils.class, "plus");

        //Configure mock for when called method MathUtils#plus(long...) return 58 long value.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "plus",
                        long[].class))
                .toReturn(58L);

        //Configure mock for when called method MathUtils#plus(int...) return 24 integer value.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "plus",
                        int[].class))
                .toReturn(24);

        //Testing long method
        assertEquals(19.3333d, MathUtils.average(new long[3]), 1e-4d);

        //Testing int method
        assertEquals(8.00d, MathUtils.average(new int[3]), 1e-2d);
    }

    @Test
    public void testAverageWithDecimal() {
        //Set up test
        PowerMock.mockStaticPartial(MathUtils.class, "plus");

        //Configure mock for when called method MathUtils#plus(double...) return 58 double value.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "plus",
                        double[].class))
                .toReturn(58d);

        //Configure mock for when called method MathUtils#plus(float...) return 24 double value.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "plus",
                        float[].class))
                .toReturn(24f);

        //Testing double method
        assertEquals(19.3333d, MathUtils.average(new double[3]), 1e-4d);
        //Testing float method
        assertEquals(8.00f, MathUtils.average(new float[3]), 1e-2d);
    }

    @Test
    public void testFact() {
        final long expected = 2432902008176640000L;
        assertEquals(expected, MathUtils.fact(20));
    }

    @Test(expected = ArithmeticException.class)
    public void testFactExpected() {
        //The next line should throw an error
        MathUtils.fact(-1L);
    }

    @Test
    public void testGcd() {
        assertEquals(14L, MathUtils.gcd(42L, -56L));
        assertEquals(6, MathUtils.gcd(12, 18));
    }

    @Test
    public void testMcm() {
        //Set up test
        PowerMock.mockStaticPartial(MathUtils.class, "gcd");

        //Configure mock for when called method MathUtils#gcd(long, long) return 1 long value.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "gcd",
                        long.class,
                        long.class))
                .toReturn(1L);
        //Testing long method
        assertEquals(12L, MathUtils.mcm(4L, 3L));

        //Configure mock for when called method MathUtils#gcd(int, int) return 6 int value.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "gcd",
                        int.class,
                        int.class))
                .toReturn(6);
        //Testing int method
        assertEquals(36, MathUtils.mcm(12, 18));
    }

    @Test
    public void testIsCoprime() {
        //Set up test
        PowerMock.mockStaticPartial(MathUtils.class, "gcd");
        //Configure mock for when called method MathUtils#gcd(long, long) return 1.
        PowerMock.stub(PowerMock
                .method(MathUtils.class,
                        "gcd",
                        long.class,
                        long.class))
                .toReturn(1L);
        //Testing
        assertTrue(MathUtils.isCoprime(anyLong(), anyLong()));
    }

    @Test
    public void testIsPrime() {
        assertTrue(MathUtils.isPrime(524287));
        assertFalse(MathUtils.isPrime(561435134));
        assertFalse(MathUtils.isPrime(-1));
    }

    @Test
    public void testPlusWithDecimal() {
        assertEquals(6.30d, MathUtils.plus(1.5d, 1.6d, 3.2d), 1e-2);
        assertEquals(6.30f, MathUtils.plus(1.5f, 1.6f, 3.2f), 1e-2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testConstructor() throws IllegalAccessException, InstantiationException {
        MathUtils.class.newInstance();
    }

}
