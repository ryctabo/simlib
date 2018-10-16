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
 * Represents a function {@code f(x)} of a real variable {@code x} that
 * is an argument of the function and produces a result.
 * <p>
 * <strong>For example:</strong>
 * <p>
 * <i>f(x) = sen(x)/x</i> is equal to {@code (x) -> (1 / x) * Math.sin(x) }
 * <p><p>
 * This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #calculate(double)}.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 * @since 1.8
 */
@FunctionalInterface
public interface Fdx {

    /**
     * Calculate the result of the function provided.
     *
     * @param x the {@code x} real variable
     *
     * @return the function result
     */
    double calculate(double x);

}
