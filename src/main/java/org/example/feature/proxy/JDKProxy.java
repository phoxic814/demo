package org.example.feature.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    protected Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk proxy invoke");
        //调用被代理类的实例对象通过反射执行目标方法
        Object result = method.invoke(target, args);
        return result;
    }

    public static void main(String[] args) {
        JDKProxy proxy = new JDKProxy();
        TestInterface testInterface = (TestInterface) proxy.getInstance(new TestImpl());
        testInterface.say();
    }
}
