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
public abstract class NumericalIntegration implements RuleX {

    protected int iterations;

    private double stepSize;

    public NumericalIntegration(int iterations) {
        this.iterations = iterations;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    protected double getStepSize() {
        return stepSize;
    }

    private void calculateStepSize(double lowerLimit, double upperLimit) {
        this.stepSize = (upperLimit - lowerLimit) / (double) iterations;
    }

    @Override
    public double solve(DefiniteIntegral di) {
        this.calculateStepSize(di.getLowerLimit(), di.getUpperLimit());
        return this.solveImplementation(di);
    }

    protected abstract double solveImplementation(DefiniteIntegral di);

}
