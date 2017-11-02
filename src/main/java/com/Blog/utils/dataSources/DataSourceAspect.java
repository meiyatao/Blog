package com.Blog.utils.dataSources;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zwt on 2017/10/25
 **/

public class DataSourceAspect implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (method.isAnnotationPresent(DataSource.class)) {
            DataSource datasource = method.getAnnotation(DataSource.class);
            DataSourceContextHolder.setDataSourceType(datasource.name());
        } else {
            DataSourceContextHolder.setDataSourceType(DataSourceType.bankManagerDataSource.toString());
        }
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        DataSourceContextHolder.clearDataSourceType();
    }
}
