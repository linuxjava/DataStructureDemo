package reflectgeneric.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * 类加载器demo
 */
public class ClassLoaderDemo {
    public static void main(String[] args){
        classLoaderTest();
    }

    /**
     * 三种classloader
     */
    private static void classLoaderTest(){
        //根类加载器
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls){
            System.out.println(url.toExternalForm());
        }

        //系统类加载器
        ClassLoader.getSystemClassLoader();
    }

    /**
     * 获取class对象
     */
    public static void getClassTest(){
        try {

            Class classz = Class.forName("java.lang.String");//方式一
            classz = String.class;//方式二
            //方式三
            String str = new String();
            str.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
