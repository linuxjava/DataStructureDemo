package reflectgeneric.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射-泛型测试类
 */
public class GenericDemo {
    public static void main(String[] args) {
        Class<?> clazz = Point.class;
        //获取clazz对应父类对应的Type
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            //获取父类原始类型
            Type rawType = ((ParameterizedType) type).getRawType();
            System.out.println("原始类型为：" + ((Class)rawType).getName());

            //获取父类所有泛型类型
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (Type parameterArgType : actualTypeArguments) {
                Class parameterArgClass = (Class) parameterArgType;
                System.out.println("填充类型为：" + parameterArgClass.getName());
            }
        }
    }
}
