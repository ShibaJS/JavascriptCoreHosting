

#include <stdlib.h>
#include <jni.h>
#include <android/log.h>

#include "JavaScriptCore/JavaScript.h"

#define NATIVE(package,rt,f) extern "C" \
    rt Java_moe_tlaster_javascriptcorehosting_##package##_##f
#define PARAMS __attribute__((unused))JNIEnv* env, __attribute__((unused))jobject thiz

