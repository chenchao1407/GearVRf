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
package org.gearvrf.controls.gamepad;

import org.gearvrf.GVRContext;
import org.gearvrf.GVRSceneObject;


public class GamepadObject extends GVRSceneObject {

    private GamepadVirtual gamepadVirtual;

    public GamepadObject(GVRContext gvrContext) {
        super(gvrContext);

        gamepadVirtual = new GamepadVirtual(gvrContext);
        
        GVRSceneObject mGVRSceneObject = new GVRSceneObject(gvrContext);
        mGVRSceneObject.addChildObject(gamepadVirtual);
        addChildObject(mGVRSceneObject);
    }

    public GamepadVirtual getGamepadVirtual() {
        return gamepadVirtual;
    }
}
