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
 * The <strong>TrapezoidalRule</strong> class represents to the
 * implementation of a numerical integration method for approximating
 * to {@link DefiniteIntegral}.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 * @see <a href="https://en.wikipedia.org/wiki/Trapezoidal_rule">Trapezoidal rule</a>
 */
public class TrapezoidalRule extends NumericalIntegration {

    /**
     * Create an instance of {@link TrapezoidalRule}.
     *
     * @param iterations number of iterations
     */
    public TrapezoidalRule(int iterations) {
        super(iterations);
    }

    /**
     * Implementation of {@link TrapezoidalRule} method.
     *
     * @param di definite integral
     *
     * @return {@code double} value, result of applying the implementation
     * of trapezoidal rule.
     */
    @Override
    protected double solveImplementation(DefiniteIntegral di) {
        Fdx fn = di.getFunction();

        double summation = 0d;
        for (int i = 1; i <= this.iterations - 1; i++) {
            summation += 2 * fn.calculate(di.getLowerLimit() + i * getStepSize());
        }

        double fdx0 = fn.calculate(di.getLowerLimit());
        double fdxN = fn.calculate(di.getUpperLimit());

        return getStepSize() / 2 * (fdx0 + summation + fdxN);
    }

}
