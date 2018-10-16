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
public class DefiniteIntegral {

    private Fdx function;

    private double lowerLimit;

    private double upperLimit;

    public DefiniteIntegral(Fdx function, double lowerLimit, double upperLimit) {
        validateLimits(lowerLimit, upperLimit);
        this.function = function;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    private void validateLimits(double lowerLimit, double upperLimit) {
        if (upperLimit < lowerLimit) {
            throw new IllegalArgumentException("The lower limit can't " +
                    "be greater than upper limit.");
        }
    }

    public Fdx getFunction() {
        return function;
    }

    public void setFunction(Fdx function) {
        this.function = function;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
        validateLimits(lowerLimit, getUpperLimit());
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
        validateLimits(getLowerLimit(), upperLimit);
    }

}