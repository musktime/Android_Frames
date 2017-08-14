package com.musk.bufferknife.tips;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by musk on 2017/8/14.
 * 什么是注解？
 * 一种安全的类似注释的机制，用来将任何的信息或元数据（metadata）与程序元素（类、方法、成员变
 * 量等）进行关联。为程序的元素（类、方法、成员变量）加上更直观更明了的说明，这些说明信息是与程
 * 序的业务逻辑无关，并且供指定的工具或框架使用
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "";

    int id() default 0;
}
