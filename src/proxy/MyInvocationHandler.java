package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        /**
         * 需要注意method.invoke使用target而不是proxy，因为proxy其实是IDog，而target是DunDog
         */
        Object result = method.invoke(target, args);
        afterMethod();

        return result;
    }

    private void beforeMethod(){
        System.out.println("beforeMethod");
    }

    private void afterMethod(){
        System.out.println("afterMethod");
    }

}
