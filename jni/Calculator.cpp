#include <jni.h>
	jdouble Java_com_nikolay_calculator_CalcJavaLayer_add(JNIEnv* env, jobject javaThis, jdouble a, jdouble b) {
  		return a+b;
	}

	jdouble Java_com_nikolay_calculator_CalcJavaLayer_subtract(JNIEnv* env, jobject javaThis, jdouble a, jdouble b) {
	  		return a-b;
	}

	jdouble Java_com_nikolay_calculator_CalcJavaLayer_multiply(JNIEnv* env, jobject javaThis, jdouble a, jdouble b) {
	  		return a*b;
	}

	jdouble Java_com_nikolay_calculator_CalcJavaLayer_divide(JNIEnv* env, jobject javaThis, jdouble a, jdouble b) {
	  		return a/b;
	}
