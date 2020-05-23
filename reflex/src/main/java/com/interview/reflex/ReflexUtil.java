package com.interview.reflex;

import com.interview.reflex.JavaClassLoader;
import com.interview.reflex.service.OrderService;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 大都督
 * @create 2020/5/23
 */
public class ReflexUtil {

    public static Object newInstance(Class classInfo) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = classInfo.getSimpleName() + "Impl";
        // 1 使用Java的反射技术拼接orderService源代码
        StringBuffer sf = new StringBuffer();
        sf.append("package com.interview.reflex.service.impl;");
        sf.append("import com.interview.reflex.service.OrderService;");
        sf.append("public class " + className + " implements OrderService {");
        Method[] methods = classInfo.getMethods();
        for (Method method : methods) {
            sf.append("public "+method.getReturnType().getSimpleName()+" "+method.getName()+"(String var1, String var2) {");
            sf.append("return \"LIGUOGANG\";");
            sf.append("}");
        }
        sf.append("}");
        // 2 讲Java源代码写入到硬盘中
        String filename = "f:/code/"+className + ".java";
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        fw.write(sf.toString());
        fw.flush();
        fw.close();
        // 3 编译class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(filename);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
        task.call();
        fileManager.close();
        // 4 使用类加载器将该Class文件读取到内存中
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        Class<?> aClass = javaClassLoader.findClass(className);
        Object o = aClass.newInstance();
        return o;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IOException {
//        method();
        OrderService orderService = (OrderService) newInstance(OrderService.class);
        String s = orderService.addOrder("liguogang", "liguogang");
        System.out.println(s);
    }

    private static void method() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取Class
        // 第一种方式
//        Class<UserEntity> userClass = UserEntity.class;
//        System.out.println(userClass.getSimpleName());
        // 第二种方式
//        Class<?> classInfo = Class.forName("com.interview.reflex.entity.UserEntity");
//        System.out.println(classInfo);
        // 第三种方式
//        UserEntity userEntity = new UserEntity();
//        Class<? extends UserEntity> userEntityClass = userEntity.getClass();
//        System.out.println(userEntityClass.getSimpleName());
        // 使用Java的反射技术new对象
        Class<?> classInfo = Class.forName("com.interview.reflex.entity.UserEntity");
        // 实例化对象 走无参构造函数 默认是执行无参的构造函数
//        UserEntity userEntity = (UserEntity) classInfo.newInstance();
//        userEntity.setUserName("liguogang");
//        System.out.println(userEntity.getUserName());
        // 实例化有参构造函数
//        Constructor<?> constructor = classInfo.getConstructor(String.class);
//        UserEntity userEntity = (UserEntity) constructor.newInstance("liguogang");
//        System.out.println(userEntity.getUserName());
        // 为字段赋值
//        Field userName = classInfo.getDeclaredField("userName");
//        UserEntity userEntity = (UserEntity) classInfo.newInstance();
        // 设置权限 private
//        if (!userName.isAccessible()) {
//            userName.setAccessible(true);
//        }
//        userName.set(userEntity, "liguogang");
//        System.out.println(userEntity.getUserName());
        // 反射调用方法
//        Method setUserName = classInfo.getDeclaredMethod("setUserName", String.class);
//        UserEntity userEntity = (UserEntity) classInfo.newInstance();
        // 方法返回值
//        Object result = setUserName.invoke(userEntity, "liguogang");
//        System.out.println(userEntity.getUserName() + "," + result);
    }
}
