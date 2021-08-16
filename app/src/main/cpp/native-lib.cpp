#include <jni.h>
#include <string>
#include "OCL_Common/OCL_Init.h"
#include "OCL_Common/Context.h"
#include "log.h"

OCL::Runtime *runtime = nullptr;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_template_MainActivity_closeOCL(JNIEnv *env, jobject thiz) {
    if(runtime!= nullptr){
        delete runtime;
    }
}extern "C"
JNIEXPORT void JNICALL
Java_com_example_template_MainActivity_initOCL(JNIEnv *env, jobject thiz) {
    if(runtime == nullptr){
        int status;
        runtime = new OCL::Runtime(status);
        LOGI("Runtime create: %d\n", status);
    }
}