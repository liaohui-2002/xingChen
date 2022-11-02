package com.liaohui.all.javaBase;

/**
 * @auther Mr.Liao
 * @date 2022/10/30 12:12
 */
public class GirlFriend {

    private String name;
    //为了能够在静态方法中，返回 gf对象，需要将其修饰为static
    //对象通常是重量级对象，饿汉式可能造成创建对象，但没使用
    private static GirlFriend gf = new GirlFriend("小红红");

    //如何保障我们只能创建一个 GirlFriend 对象
    //步骤[单例模式-饿汉式]
    //1. 将构造器私有化
    //2. 在类的内部直接创建对象(该对象是static)
    //3. 提供一个公共的static方法，返回 gf对象
    private GirlFriend(String name) {
        System.out.println("构造器被调用...");
        this.name = name;
    }
    public static GirlFriend getInstance() {
        return gf;
    }
    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);//true
    }
}
