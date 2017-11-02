package com.Blog.utils.dataSources;

import java.lang.annotation.*;

/**
 * Created by zwt on 2017/10/25
 **/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.bankManager;
    public static String bankManager = "bankManagerDataSource";
    public static String serviceManager = "serviceManagerDataSource";

}
