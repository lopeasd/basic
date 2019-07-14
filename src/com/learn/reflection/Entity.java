package com.learn.reflection;

import java.io.Serializable;

public class Entity implements Cloneable, Serializable {

    private int age;

    protected char sex;

    float height;

    public String name;

    public  Entity(){

    }

    @Override
    //浅拷贝 拷贝对象和原始对象的引用类型引用同一个对象
    protected Entity clone() throws CloneNotSupportedException {
        return (Entity)super.clone();
    }

    public Entity(String name) {
        this.name = name;
    }

    public void emthod() {
        System.out.println("this is public method and haven't parameter ");
    }

    public void method(String str) {
        System.out.println("this is public method and have parameter" + str);
    }

    void method2() {
        System.out.println("this is default method");
    }

    void method2(String str) {
        System.out.println("this is defautl method and have parameter" + str);
    }

    protected void method1() {
        System.out.println("protected method and haven't parameter");
    }

    protected void method1(String str) {
        System.out.println("protected method and have parameter" + str);
    }

    private void method3() {
        System.out.println("this is private method haven't parameter");
    }

    private void method3(String str) {
        System.out.println("this is private method and have parameter" + str);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
