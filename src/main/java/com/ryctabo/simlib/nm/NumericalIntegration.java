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
 * The <strong>NumericalIntegration</strong> class represents a family
 * of algorithms for calculating the numerical value of a {@link DefiniteIntegral}.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public abstract class NumericalIntegration implements RuleX {

    /**
     * Number of iterations.
     * <p>
     * Represented in formulas of numerical methods such as {@code (n)}
     */
    protected int iterations;

    /**
     * Result of an operation where:
     * <p>
     * - Integral <i>f(x)</i> with interval {@code [a,b]} and number of iterations {@code (n)}.
     * <p>
     * Is equal to:
     * <p>
     * - {@code stepSize = (b - a) / n }
     */
    private double stepSize;

    /**
     * Create an instance of {@link NumericalIntegration}.
     *
     * @param iterations number of iterations
     */
    public NumericalIntegration(int iterations) {
        this.iterations = iterations;
    }

    /**
     * Get the number of iterations.
     *
     * @return number of iterations
     */
    public int getIterations() {
        return iterations;
    }

    /**
     * Set the number of iterations.
     *
     * @param iterations number of iterations
     */
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    /**
     * Get step size property.
     *
     * @return step size
     */
    protected double getStepSize() {
        return stepSize;
    }

    /**
     * Assign the value resulting from the operation: {@code (b-a)/n}
     * to the property {@code stepSize} for user.
     *
     * @param lowerLimit the lower limit of an integral
     * @param upperLimit the upper limit of an integral
     */
    private void calculateStepSize(double lowerLimit, double upperLimit) {
        this.stepSize = (upperLimit - lowerLimit) / (double) iterations;
    }

    @Override
    public double solve(DefiniteIntegral integral) {
        this.calculateStepSize(integral.getLowerLimit(), integral.getUpperLimit());
        return this.solveImplementation(integral);
    }

    /**
     * Implements a numerical integration method.
     *
     * @param di definite integral
     *
     * @return {@code double} value, result of applying an implementation
     * of a numerical integration rule.
     */
    protected abstract double solveImplementation(DefiniteIntegral di);

}
