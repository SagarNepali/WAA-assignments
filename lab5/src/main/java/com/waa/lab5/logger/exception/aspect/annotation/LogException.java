package com.waa.lab5.logger.exception.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface LogException {
}
