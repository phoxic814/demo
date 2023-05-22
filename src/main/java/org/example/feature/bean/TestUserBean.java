package org.example.feature.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 實現各式接口
 * https://segmentfault.com/a/1190000040365130
 */
@Component
public class TestUserBean implements InitializingBean, BeanNameAware, DisposableBean {

    // ApplicationContextAware

    private int id;
    private String name;

    @PostConstruct
    public void afterConstruct() {
        System.out.println("invoke after construct");
        setId(1);
        setName("name");
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("set id");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("set name");
    }

    public int getId() {
        return id;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("invoke BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() {
        System.out.println("invoke DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("invoke InitializingBean.afterPropertiesSet()");
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        TestUserBean userBean = applicationContext.getBean(TestUserBean.class);
//        System.out.println(userBean);
//        System.out.println("invoke BeanNameAware.setBeanName() ");
//    }

}
