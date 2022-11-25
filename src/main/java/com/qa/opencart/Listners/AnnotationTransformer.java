package com.qa.opencart.Listners;



import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.qa.opencart.listners.Retry;

public class AnnotationTransformer implements IAnnotationTransformer   {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
	}
	
	

}
