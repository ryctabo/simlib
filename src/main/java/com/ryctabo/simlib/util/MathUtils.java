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

import java.util.ArrayList;
import java.util.List;

/**
 * The <strong>MathUtils</strong> class contains only utility functions.
 *
 * @author Gustavo Pacheco
 * @version 1.0
 */
public final class MathUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private MathUtils() {
        throw new UnsupportedOperationException("This class is not instantiable.");
    }

    /**
     * Result the sum of all {@code int} values.
     *
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static int plus(int... values) {
        int result = 0;
        for (int value : values)
            result += value;
        return result;
    }

    /**
     * Result the sum of all {@code long} values.
     *
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static long plus(long... values) {
        long result = 0L;
        for (long value : values)
            result += value;
        return result;
    }

    /**
     * Result the sum of all {@code float} values.
     *
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static float plus(float... values) {
        float result = 0f;
        for (float value : values)
            result += value;
        return result;
    }

    /**
     * Result the sum of all {@code double} values.
     *
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static double plus(double... values) {
        double result = 0d;
        for (double value : values)
            result += value;
        return result;
    }

    /**
     * Returns the average of the given {@code int} values.
     *
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see MathUtils#plus(int...)
     */
    public static double average(int... values) {
        return ((double) MathUtils.plus(values)) / values.length;
    }

    /**
     * Returns the average of the given {@code long} values.
     *
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see MathUtils#plus(long...)
     */
    public static double average(long... values) {
        return ((double) MathUtils.plus(values)) / values.length;
    }

    /**
     * Returns the average of the given {@code double} values.
     *
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see MathUtils#plus(float...)
     */
    public static float average(float... values) {
        return MathUtils.plus(values) / values.length;
    }


    /**
     * Returns the average of the given {@code double} values.
     *
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see MathUtils#plus(double...)
     */
    public static double average(double... values) {
        return MathUtils.plus(values) / values.length;
    }

    /**
     * Returns the factorial of the {@code value} given. For every positive
     * integer {@code x} then, {@code fact(x) == x!}. But, if {@code x} is
     * negative then the factorial can't be calculated.
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is negative, then the result can't be calculated.
     * <li>If the argument is zero, then the result is 1.
     * </ul>
     *
     * @param value a value
     * @return the factorial of {@code value}
     * @throws ArithmeticException if the given value is negative.
     */
    public static long fact(long value) {
        if (value < 0) throw new ArithmeticException("the value can't be negative.");
        return value == 0 ? 1 : value * fact(value - 1);
    }

    /**
     * Returns the greatest common divisor of {@code a} and {@code b}, the given
     * {@code int} values.
     * <p>
     * Note that it does not consider the negative arguments.
     *
     * @param a a first value
     * @param b a second value
     * @return the greatest common divisor of the given values
     * @see Math#abs(long)
     */
    public static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    /**
     * Returns the greatest common divisor of {@code a} and {@code b}, the given
     * {@code long} values.
     * <p>
     * Note that it does not consider the negative arguments.
     *
     * @param a a first value
     * @param b a second value
     * @return the greatest common divisor of the given values
     * @see Math#abs(long)
     */
    public static long gcd(long a, long b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    /**
     * This method return the minimum common multiple of {@code a} and {@code b},
     * the given {@code long} values.
     * <p>Note that it does not consider the negative arguments.</p>
     *
     * @param a the first value
     * @param b the second value
     * @return the minimum common multiple of the given values
     * @see MathUtils#gcd(int, int)
     * @see Math#abs(long)
     */
    public static int mcm(int a, int b) {
        return Math.abs(a) * Math.abs(b) / gcd(a, b);
    }

    /**
     * This method return the minimum common multiple of {@code a} and {@code b},
     * the given {@code long} values.
     * <p>Note that it does not consider the negative arguments.</p>
     *
     * @param a the first value
     * @param b the second value
     * @return the minimum common multiple of the given values
     * @see MathUtils#gcd(long, long)
     * @see Math#abs(long)
     */
    public static long mcm(long a, long b) {
        return Math.abs(a) * Math.abs(b) / gcd(a, b);
    }

    /**
     * Return {@code true} if {@code a} and {@code b} is relatively primes.
     *
     * @param a a first value
     * @param b a second value
     * @return true, if {@code a} and {@code b} is relatively primes.
     * @see MathUtils#gcd(long, long)
     * @see MathUtils#isPrime(long)
     */
    public static boolean isCoprime(long a, long b) {
        return gcd(a, b) == 1L;
    }

    /**
     * Returns {@code true} if the given number is prime.
     * <p>
     * This method uses primality test algorithm of Lucas-Lehmer for
     * Mersenne numbers.
     *
     * @param value a value
     * @return true, if number is prime
     * @see MathUtils#isCoprime(long, long)
     */
    public static boolean isPrime(long value) {
        if (value < 4) return value > 1;
        if (value % 2 == 0 || value % 3 == 0) return false;
        else {
            for (int i = 5; i * i <= value; i += 6)
                if (value % i == 0 || value % (i + 2) == 0) return false;
        }
        return true;
    }

    /**
     * Get prime factors array from the given {@code value}.
     * <p><strong>For example:</strong></p>
     * <p>If {@code value} is 14 then the prime factors is [2, 7]</p>
     *
     * @param value any value
     * @return prime factors
     */
    public static int[] getPrimeFactors(int value) {
        List<Integer> primes = new ArrayList<>();
        int temp = value, div = 2;
        while (temp > 1) {
            if (temp % div == 0) {
                temp /= div;
                primes.add(div);
            } else {
                div++;
            }
        }
        int[] array = new int[primes.size()];
        for (int i = 0; i < primes.size(); i++)
            array[i] = primes.get(i);
        return array;
    }

    /**
     * Get prime factors array from the given {@code value}.
     * <p><strong>For example:</strong></p>
     * <p>If {@code value} is 14 then the prime factors is [2, 7]</p>
     *
     * @param value any value
     * @return prime factors
     */
    public static long[] getPrimeFactors(long value) {
        List<Long> primes = new ArrayList<>();
        long temp = value, div = 2;
        while (temp > 1) {
            if (temp % div == 0) {
                temp /= div;
                primes.add(div);
            } else {
                div++;
            }
        }
        long[] array = new long[primes.size()];
        for (int i = 0; i < primes.size(); i++)
            array[i] = primes.get(i);
        return array;
    }

}
