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
 * Represents a function that accepts one {@link DefiniteIntegral}
 * and produces a result of that integral {@code f(x)} in a interval
 * {@code [a,b]} of the real line.
 * <p>
 * This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #solve(DefiniteIntegral)}.
 *
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 * @since 1.8
 */
@FunctionalInterface
public interface RuleX {

    /**
     * Returns a {@code double} value that represents the result of
     * solving a definite integral {@code f(x)} with an interval {@code [a,b]}.
     *
     * @param integral Integral {@code f(x)} with an interval {@code [a,b]}.
     *
     * @return result to solve the definite integral.
     */
    double solve(DefiniteIntegral integral);

}
