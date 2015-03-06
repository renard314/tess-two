/*
 * Copyright (C) 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.leptonica.android;

/**
 * Image scaling methods.
 * 
 * @author alanv@google.com (Alan Viverette)
 */
public class Bilinear {
    static {
        System.loadLibrary("lept");
    }



    /**
     *  pixBilinearPta()
     *
     *      Input:  pixs (all depths; colormap ok)
     *              dest  (4 pts of final coordinate space)
     *              src  (4 pts of initial coordinate space)
     *      Return: pixd, or null on error
     *
     *  Notes:
     *      (1) Brings in either black or white pixels from the boundary
     *      (2) Removes any existing colormap, if necessary, before transforming
     */
    public static Pix bilinear(Pix pixs, float[] dest, float[] src) {
        if (pixs == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        final long result = nativeBilinear(pixs.getNativePix(), dest, src);
        return new Pix(result);
    }


    // ***************
    // * NATIVE CODE *
    // ***************

    private static native long nativeBilinear(long pix , float[] dest, float[] src);
}
