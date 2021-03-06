/*
   Copyright 2013 Stephen K Samuel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.sksamuel.scrimage.filter;

import com.sksamuel.scrimage.BufferedOpFilter;

import java.awt.image.BufferedImageOp;
import java.util.Random;

public class SwimFilter extends BufferedOpFilter {

    private final Random random;
    private final float amount;
    private final float stretch;

    public SwimFilter(Random random, float amount, float stretch) {
        this.random = random;
        this.amount = amount;
        this.stretch = stretch;
    }

    public SwimFilter(Random random) {
        this(new Random(), 6f, 2f);
    }

    public SwimFilter(float amount, float stretch) {
        this(new Random(), amount, stretch);
    }

    public SwimFilter() {
        this(6f, 2f);
    }

    @Override
    public BufferedImageOp op() {
        thirdparty.jhlabs.image.SwimFilter op = new thirdparty.jhlabs.image.SwimFilter(random);
        op.setAmount(amount);
        op.setStretch(stretch);
        return op;
    }
}
