package com.owen.singleton;
/**
 * @Author：Owen
 * @Package：com.owen.singleton
 * @Project：PatternDesign
 * @name：InnerClassTests
 * @Date：2022/11/28 22:22
 * @Filename：InnerClassTests
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OwenHuang
 * @since 2022/11/28 22:22
 */
public class SingletonTests {

    private void check(List<?> singletons) {
        for (int idx = 0; idx < singletons.size() - 1; idx++) {
            Assertions.assertTrue(singletons.get(idx) == singletons.get(idx + 1));
        }
    }

    @Test
    public void testInnerClassSingletonSuccess() {
        final List<StaticInnerClassSingleton> singletons = new ArrayList<>();
        for (int idx = 0; idx < 1000; idx++) {
            new Thread(
                    () -> singletons.add(StaticInnerClassSingleton.getInstance())
            ).start();
        }
        check(singletons);
    }

    @Test
    public void testDoubleCheckLockSingletonSuccess() {
        final List<DoubleCheckLockSingleton> singletons = new ArrayList<>();
        for (int idx = 0; idx < 1000; idx++) {
            new Thread(
                    () -> {
                        singletons.add(DoubleCheckLockSingleton.getInstance());
                    }
            ).start();
        }
        check(singletons);
    }

    @Test
    public void testDoubleCheckSingletonReflectionSuccess() {
        Assertions.assertThrows(InvocationTargetException.class, () -> {
            Class<DoubleCheckLockSingleton> clz = DoubleCheckLockSingleton.class;
            Constructor<DoubleCheckLockSingleton> constructor = clz.getDeclaredConstructor();
            constructor.setAccessible(true);
            DoubleCheckLockSingleton instance1 = constructor.newInstance();
            DoubleCheckLockSingleton instance2 = constructor.newInstance();
            Assertions.assertTrue(instance1 == instance2);
        });
    }

    /**
     * 重写readResolve方法之后通过反序列化获取的对象也是单例的
     * @throws IOException IO异常
     * @throws ClassNotFoundException 类不存在异常
     */
    @Test
    public void testDoubleCheckLockSingletonSerializationSuccess() throws IOException, ClassNotFoundException {
        String filename = "E:\\projects/singleton.txt";
        File file = new File(filename);
        if (!file.exists()){
            file.createNewFile();
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(DoubleCheckLockSingleton.getInstance());
        outputStream.flush();
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        DoubleCheckLockSingleton instance1 = DoubleCheckLockSingleton.getInstance();
        DoubleCheckLockSingleton instance2 = (DoubleCheckLockSingleton)inputStream.readObject();
        Assertions.assertSame(instance1,instance2);
    }

    @Test
    public void testEnumSingletonSuccess(){
        final List<EnumSingleton> singletons = new ArrayList<>();
        for (int idx = 0; idx < 1000; idx++) {
            new Thread(
                    () -> {
                        singletons.add(EnumSingleton.INSTANCE);
                    }
            ).start();
        }
        check(singletons);
    }
}
