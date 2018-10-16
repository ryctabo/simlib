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
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public class SimpsonsRule extends NumericalIntegration {

    public enum Composite {
        MAIN(2, 4, 2), THREE_EIGHTHS(3, 3, 2);

        final int modulus;

        final int m1;

        final int m2;

        Composite(int modulus, int m1, int m2) {
            this.modulus = modulus;
            this.m1 = m1;
            this.m2 = m2;
        }

    }

    private Composite composite = Composite.MAIN;

    public SimpsonsRule(int iterations) {
        super(iterations);
        validateIterations();
    }

    public SimpsonsRule(int iterations, Composite composite) {
        super(iterations);

        if (composite == null)
            throw new NullPointerException("The composite can't be null");

        this.composite = composite;
        validateIterations();
    }

    public Composite getComposite() {
        return composite;
    }

    @Override
    public void setIterations(int iterations) {
        super.setIterations(iterations);
        validateIterations();
    }

    private void validateIterations() {
        if (this.iterations % this.composite.modulus != 0) {
            final String formatter = "The number of iterations has to bea module of %d";
            throw new ArithmeticException(String.format(formatter, this.composite.modulus));
        }
    }

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
