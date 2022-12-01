package com.glarimy.factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Classes with this annotation can get the dependencies injected by the ObjectFactory.
 * 
 * The class that have a dependency must use this annotation at the class level, 
 * and the key must be supplied as a parameter to the annotation.
 * And the key must present in the config file.
 * 
 * @author glarimy
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Wire {
	public String target();
}
