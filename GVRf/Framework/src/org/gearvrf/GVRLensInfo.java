/* Copyright 2015 Samsung Electronics Co., LTD
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

package org.gearvrf;

import org.gearvrf.utility.VrAppSettings;

/**
 * This class holds distortion parameters (from an XML file, read by
 * {@link GVRXMLParser}) and is used in {@link GVRViewManager}.
 */
class GVRLensInfo {
    private final VrAppSettings mAppSettings;
    private final float mRealScreenWidthMeters;
    private final int mHorizontalRealScreenPixels;
    private final int mVerticalRealScreenPixels;
    private final float mRealScreenHeightMeters;

    /**
     * Constructs a GVRLensInfo object with distortion data which requires a
     * valid, pre-processed GVRXMLParser object
     * 
     * @param screenWidthPixels
     *            the screen width in pixels
     * @param screenHeightPixels
     *            the screen height in pixels
     * @param screenWidthMeters
     *            the screen width in meters
     * @param screenHeightMeters
     *            the screen height in meters
     * @param xmlParser
     *            other parameters holds in GVRXMLParser
     */
    public GVRLensInfo(int screenWidthPixels, int screenHeightPixels,
            float screenWidthMeters, float screenHeightMeters,
            VrAppSettings appSettings) {
        /*
         * Sets values which don't need combinations.
         */
        mAppSettings = appSettings;
        mRealScreenWidthMeters = screenWidthMeters * 0.5f;
        mRealScreenHeightMeters = screenHeightMeters;
        mHorizontalRealScreenPixels = screenWidthPixels / 2;
        mVerticalRealScreenPixels = screenHeightPixels;
        update();
    }

    /**
     * Updates the distortion offset by current distortion data Note: distortion
     * offset = ( 0.5 * real screen width in meters - 0.5 * Lens Separation in
     * meters ) / real screen width in meters
     */
    public void update() {
    }

    /**
     * Returns current distortion FBO width value
     * 
     * @return current distortion FBO width value
     */
    public int getFBOWidth() {
        //return mAppSettings.getFramebufferPixelsWide() <= 0 ? getHorizontalRealScreenPixels()
          //      : mAppSettings.getFramebufferPixelsWide() / 2;
        return mAppSettings.getEyeBufferParms().getResolution() * mAppSettings.getEyeBufferParms().getWidthScale();
    }

    /**
     * Returns current distortion FBO height value
     * 
     * @return current distortion FBO height value
     */
    public int getFBOHeight() {
//        return mAppSettings.getFramebufferPixelsHigh() <= 0 ? getVerticalRealScreenPixels()
 //               : mAppSettings.getFramebufferPixelsHigh();
        return mAppSettings.getEyeBufferParms().getResolution();
    }

    /**
     * Returns current distortion MSAA value
     * 
     * @return current distortion MSAA value
     */
    public int getMSAA() {
        return mAppSettings.getEyeBufferParms().getMultiSamples() < 0 ? 0
                : mAppSettings.getEyeBufferParms().getMultiSamples();
    }

    /**
     * Returns current real screen width in meters
     * 
     * @return current real screen width in meters
     */
    public float getRealScreenWidthMeters() {
        return mRealScreenWidthMeters;
    }

    /**
     * Returns current horizontal real screen in pixels
     * 
     * @return current horizontal real screen in pixels
     */
    public int getHorizontalRealScreenPixels() {
        return mHorizontalRealScreenPixels;
    }

    /**
     * Returns current vertical real screen in pixels
     * 
     * @return current vertical real screen in pixels
     */
    public int getVerticalRealScreenPixels() {
        return mVerticalRealScreenPixels;
    }

    /**
     * Returns current real screen height in meters
     * 
     * @return current real screen height in meters
     */
    public float getRealScreenHeightMeters() {
        return mRealScreenHeightMeters;
    }
}
