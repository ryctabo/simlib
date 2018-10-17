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
 * The <strong>SimpsonsRule</strong> class represents to the
 * implementation of a numerical integration method for approximating
 * to {@link DefiniteIntegral}.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 * @see <a href="https://en.wikipedia.org/wiki/Simpson%27s_rule">Simpson's rule</a>
 */
public class SimpsonsRule extends NumericalIntegration {

    /**
     * Represents a composition of {@link SimpsonsRule}.
     */
    public enum Composite {

        /** The main composite of Simpson's rule. */
        MAIN(2, 4, 2),

        /** The composite of Simpson's 3/8 rule. */
        THREE_EIGHTHS(3, 3, 2);

        /** The modulus */
        final int modulus;

        /** The first multiplier. */
        final int m1;

        /** The second multiplier. */
        final int m2;

        /**
         * Create an enumeration from the given parameters.
         *
         * @param modulus the modulus
         * @param m1      the first multiplier
         * @param m2      the second multiplier
         */
        Composite(int modulus, int m1, int m2) {
            this.modulus = modulus;
            this.m1 = m1;
            this.m2 = m2;
        }

    }

    /** The composite of Simpson's rule. */
    private Composite composite = Composite.MAIN;

    /**
     * Create an instance of {@link SimpsonsRule} from the given
     * parameters and the main composite.
     *
     * @param iterations number of iterations
     */
    public SimpsonsRule(int iterations) {
        super(iterations);
        validateIterations();
    }

    /**
     * Create an intance of {@link SimpsonsRule} from the given
     * parameters.
     *
     * @param iterations the number of iterations
     * @param composite  the composite Simpson's rule
     */
    public SimpsonsRule(int iterations, Composite composite) {
        super(iterations);

        if (composite == null)
            throw new NullPointerException("The composite can't be null");

        this.composite = composite;
        validateIterations();
    }

    /**
     * Get composite of Simpson's rule.
     *
     * @return the composite
     */
    public Composite getComposite() {
        return composite;
    }

    @Override
    public void setIterations(int iterations) {
        super.setIterations(iterations);
        validateIterations();
    }

    /**
     * Validate if the number of iterations is valid for
     * apply the Simpson's rule.
     *
     * @throws ArithmeticException if the number of iterations are invalid to
     *                             apply the Simpson's rule
     */
    private void validateIterations() {
        if (this.iterations % this.composite.modulus != 0) {
            final String formatter = "The number of iterations has to bea module of %d";
            throw new ArithmeticException(String.format(formatter, this.composite.modulus));
        }
    }

    /**
     * Implementation of {@link SimpsonsRule} method.
     *
     * @param di definite integral
     *
     * @return {@code double} value, result of applying the implementation
     * of Simpson's rule.
     */
    @Override
    protected double solveImplementation(DefiniteIntegral di) {
        Fdx fn = di.getFunction();

        double summation = 0d;
        for (int i = 1; i <= this.iterations - 1; i++) {
            int multiplier = i % this.composite.modulus == 0 ? this.composite.m2 : this.composite.m1;
            summation += multiplier * fn.calculate(di.getLowerLimit() + i * getStepSize());
        }

        double fdx0 = fn.calculate(di.getLowerLimit());
        double fdxN = fn.calculate(di.getUpperLimit());

        double multiplier = 0d;
        switch (this.composite) {
            case MAIN:
                multiplier = getStepSize() / 3;
                break;
            case THREE_EIGHTHS:
                multiplier = 3 * getStepSize() / 8;
                break;
        }
        return multiplier * (fdx0 + summation + fdxN);
    }

}
