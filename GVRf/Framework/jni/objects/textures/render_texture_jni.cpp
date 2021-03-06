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


/***************************************************************************
 * JNI
 ***************************************************************************/

#include "render_texture.h"

#include "util/gvr_jni.h"

namespace gvr {
extern "C" {
JNIEXPORT jlong JNICALL
Java_org_gearvrf_NativeRenderTexture_ctor(JNIEnv * env,
        jobject obj, jint width, jint height);
JNIEXPORT jlong JNICALL
Java_org_gearvrf_NativeRenderTexture_ctorMSAA(JNIEnv * env,
        jobject obj, jint width, jint height, jint sample_count);
}
;

JNIEXPORT jlong JNICALL
Java_org_gearvrf_NativeRenderTexture_ctor(JNIEnv * env,
        jobject obj, jint width, jint height) {
    return reinterpret_cast<jlong>(new RenderTexture(width, height));
}

JNIEXPORT jlong JNICALL
Java_org_gearvrf_NativeRenderTexture_ctorMSAA(JNIEnv * env,
        jobject obj, jint width, jint height, jint sample_count) {
    return reinterpret_cast<jlong>(new RenderTexture(width, height, sample_count));
}

}
