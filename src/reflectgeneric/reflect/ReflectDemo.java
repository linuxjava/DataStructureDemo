package reflectgeneric.reflect;

import sun.misc.Launcher;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * 类加载器demo
 */
public class ReflectDemo {
    public static void main(String[] args) {
        //createObject();
        invokeMethod();
    }

    /**
     * 反射创建对象
     */
    private static void createObject() {
        try {
            Constructor<String> constructor = String.class.getConstructor(String.class);
            String str = constructor.newInstance("test");
            System.out.println(str);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射调用方法
     */
    private static void invokeMethod() {
        try {
            Test tesObj = new Test();
            //getMethod只能获取public方法
            Method method = Test.class.getMethod("method1", String.class);
            method.setAccessible(true);
            method.invoke(tesObj, "获取public方法");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Test tesObj = new Test();
            //getDeclaredMethod能获取所有方法
            Method method = Test.class.getDeclaredMethod("method2", String.class);
            method.setAccessible(true);
            method.invoke(tesObj, "获取private方法");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
