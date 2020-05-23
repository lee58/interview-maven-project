package com.interview.reflex.service.impl;

import com.interview.reflex.entity.Size;
import com.interview.reflex.service.ReflexService;
import com.interview.reflex.entity.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 大都督
 * @create 2020/5/22
 */
@Service
public class ReflexServiceImpl implements ReflexService {
    @Override
    public void printClass() {
        // 实例对象获取类
        Class<? extends User> aClass = new User().getClass();
        // 类名获取类
        Class<Date> dateClass = Date.class;
        // 接口的Class对象
        Class<Comparable> comparableClass = Comparable.class;
        // 基本类型对应的Class对象
        Class<Integer> integerClass = int.class;
        Class<Byte> byteClass = byte.class;
        Class<Character> characterClass = char.class;
        Class<Double> doubleClass = double.class;
        // void对应的Class
        Class<Void> voidClass = void.class;
        // 数组，每种数组都有对应的Class对象
        String[] strings = new String[10];
        Class<? extends String[]> aClass1 = strings.getClass();
        int[][] ints = new int[3][2];
        Class<? extends int[][]> aClass2 = ints.getClass();
        int[] ints1 = new int[10];
        Class<? extends int[]> aClass3 = ints1.getClass();
        // 枚举类型对应的Class
        Class<Size> sizeClass = Size.class;

        // Class有一个静态方法forName，可以根据类名直接加载Class，获取Class对象，比如：
        try {
            Class<?> aClass4 = Class.forName("java.util.HashMap");
            System.out.println("aClass4:" + aClass4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printClassName(String className, Class<? > cls) {
        System.out.println(className +".getName():" + cls.getName());
        System.out.println(className + ".getSimpleName():" + cls.getSimpleName());
        System.out.println(className + ".getCanonicalName():" + cls.getCanonicalName());
        System.out.println(className + ".getPackage():" + cls.getPackage());
    }

    @Override
    public void printFieldInfo(Class<?> cls) {
        // 返回所有public字段，包括父类的，如果没有字段，返回空数组
        Field[] fields = cls.getFields();
        Arrays.stream(fields).forEach(field -> {
            System.out.println("fields:" + field.getName());
        });
        // 返回本类声明的字段，包括非public,但不包括父类的
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> System.out.println("declaredFields:" + field.getName()));
    }
}
