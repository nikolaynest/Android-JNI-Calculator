LOCAL_PATH := $(call my-dir)
	include $(CLEAR_VARS) 
	# Here we give our module name and source file(s)
	LOCAL_MODULE    := Calc
	LOCAL_SRC_FILES := Calculator.cpp
	include $(BUILD_SHARED_LIBRARY)