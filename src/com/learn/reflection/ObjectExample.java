package com.learn.reflection;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建对象的四种方式
 * 1. Class.forName();
 * 2.对象.getClass();
 * 3.类名.class
 * 4.类加载器ClassLoader
 * 5.clone
 * 6.序列化
 */
public class ObjectExample {
    public static void main(String[] args) {
        demo7();
        Integer i;
    }

    //序列化
    private static void demo7() {
        Entity entity = new Entity();
        entity.name = "xuliehua";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/test.class"))) {
            oos.writeObject(entity);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 反序列化
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/test.class"))) {
            Entity entity1 = (Entity) ois.readObject();
            System.out.println("反序列化：" + entity1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //clone
    private static void demo6(Entity entity) throws CloneNotSupportedException {
        entity.name = "clone";
        Entity clone = entity.clone();
        System.out.println(clone);
    }

    //构造器中的newInstance
    private static void demo5() {
        try {
            Entity entity = Entity.class.getConstructor(String.class).newInstance("parameter");
            System.out.println(entity);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    //ClassLoader
    private void demo4() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            Class<?> aClass = classLoader.loadClass("com.learn.reflection.Entity");
            Entity o = (Entity) aClass.newInstance();
            o.name = "ClassLoader";
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    //对象.getClass newInstance
    private static void demo3() {
        Entity entity = new Entity();
        try {
            Entity entity1 = entity.getClass().newInstance();
            entity1.name = "getClass";
            System.out.println(entity1);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //类名.class newInstance
    private static void demo1() {
        try {
            Entity entity = Entity.class.newInstance();
            entity.name = ".class";
            System.out.println(entity);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Class.forName
    private static void demo2() {
        try {
            Class<?> aClass = Class.forName("com.learn.reflection.Entity");
            Entity o = (Entity) aClass.newInstance();
            o.name = "forName";
            System.out.println(o);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
