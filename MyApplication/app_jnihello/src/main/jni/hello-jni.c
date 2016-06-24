//
// Created by markmin on 16/6/23.
//

#include <string.h>
#include <jni.h>
jstring
Java_com_example_myapplication_HelloJni_stringFromJNI( JNIEnv* env,
                                                  jobject thiz )
{
 return (*env)->NewStringUTF(env, "Hello from JNI !  Compiled with ABI ");
 }