package com.example.demo.annotation;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {
    /**
     * 是否非空,默认不能为空
     */
    boolean notNull() default true;

}
