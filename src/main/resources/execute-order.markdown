# WEB架構 由大到小 (外圈 -> 內圈)
`
tomcat > filter > servlet > Interceptor > controller
`

# order of execution
`
ServletContextListener > Filter > Interception > AOP > 具体执行的方法 > AOP > @ControllerAdvice > Interception > Filter > ServletContextListener
`
- Filter 和 Listener：依赖 Servlet 容器，基于函数回调实现。可以拦截所有请求，覆盖范围更广，但无法获取 ioc 容器中的 bean
- Interceptor 和 aop：依赖 spring 框架，基于 java 反射和动态代理实现。只能拦截 controller 的请求，可以获取 ioc 容器中的 bean。

# interceptor
![](interceptor.png )
