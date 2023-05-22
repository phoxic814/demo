package org.example.datasource;

import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class DataSwitchAop {

    private Logger logger = LoggerFactory.getLogger(DataSwitchAop.class);

    @Pointcut("@annotation(org.example.datasource.DataSourceSwitcher)")
    public void dataSourceSwitcher() {
    }

    @Around("dataSourceSwitcher()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        DataSourceEnum dataSourceEnum = getAnnotation(joinPoint).value();
        DataSourceContextHolder.setDataSourceType(dataSourceEnum.name());
        logger.info("switch data source: {}", dataSourceEnum.name());
        try {
            return joinPoint.proceed();
        } finally {
            DataSourceContextHolder.clearDataSourceType();
        }
    }

    /**
     * 根据类或方法获取数据源注解
     */
    private DataSourceSwitcher getAnnotation(ProceedingJoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        DataSourceSwitcher dsAnnotation = targetClass.getAnnotation(DataSourceSwitcher.class);
        // 先判断类的注解，再判断方法注解
        if (Objects.nonNull(dsAnnotation)) {
            return dsAnnotation;
        } else {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            return methodSignature.getMethod().getAnnotation(DataSourceSwitcher.class);
        }
    }
}
