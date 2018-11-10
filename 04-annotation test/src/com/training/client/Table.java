package com.training.client;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME) // available in the source code of file 

public @interface Table {

	String name(); //string type of element
	
	
}
