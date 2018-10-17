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

/**
 * The <strong>DefiniteIntegral</strong> class represents a function
 * {@code f(x)} of a real variable {@code x} and an interval of
 * {@code [a, b]} of the real line.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 * @see <a href="https://en.wikipedia.org/wiki/Integral">Integral</a>
 */
public class DefiniteIntegral {

    /** The function {@code f(x)} of a real variable {@code x}. */
    private Fdx function;

    /** The lower limit of an integral. */
    private double lowerLimit;

    /** The upper limit of an integral. */
    private double upperLimit;

    /**
     * Create an instance of {@link DefiniteIntegral}.
     *
     * @param function   the function <i>f(x)</i>
     * @param lowerLimit the lower limit of an integral
     * @param upperLimit the upper limit of an integral
     */
    public DefiniteIntegral(Fdx function, double lowerLimit, double upperLimit) {
        validateLimits(lowerLimit, upperLimit);
        this.function = function;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    /**
     * Validate if the lower limit is greater than upper limit.
     * <p>
     * If the lower limit is greater than upper limit then it throws
     * an exception.
     *
     * @param lowerLimit the lower limit of an integral
     * @param upperLimit the upper limit of an integral
     *
     * @throws IllegalArgumentException if the lower limit is greater than
     *                                  upper limit.
     */
    private void validateLimits(double lowerLimit, double upperLimit) {
        if (upperLimit < lowerLimit) {
            throw new IllegalArgumentException("The lower limit can't " +
                    "be greater than upper limit.");
        }
    }

    /**
     * Get the function.
     *
     * @return the function
     */
    public Fdx getFunction() {
        return function;
    }

    /**
     * Set the function.
     *
     * @param function the function {@code f(x)}
     */
    public void setFunction(Fdx function) {
        this.function = function;
    }

    /**
     * Get the lower limit of an integral.
     *
     * @return the lower limit
     */
    public double getLowerLimit() {
        return lowerLimit;
    }

    /**
     * Set the lower limit of an integral.
     *
     * @param lowerLimit the lower limit
     *
     * @see #validateLimits(double, double)
     */
    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
        validateLimits(lowerLimit, getUpperLimit());
    }

    /**
     * Get the upper limit of an integral.
     *
     * @return the upper limit
     */
    public double getUpperLimit() {
        return upperLimit;
    }

    /**
     * Set the upper limit of an integral.
     *
     * @param upperLimit the upper limit
     *
     * @see #validateLimits(double, double)
     */
    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
        validateLimits(getLowerLimit(), upperLimit);
    }

    /**
     * Set interval {@code [a, b]} of an <strong>Definite Integral</strong>.
     *
     * @param lowerLimit the lower limit of an integral
     * @param upperLimit the upper limit of an integral
     *
     * @see #validateLimits(double, double)
     */
    public void setInterval(double lowerLimit, double upperLimit) {
        validateLimits(lowerLimit, upperLimit);
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

}
