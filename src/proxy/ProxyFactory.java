package proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getProxy(Object target) {
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.setTarget(target);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), invocationHandler);
    }

}
