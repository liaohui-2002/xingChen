package com.liaohui.all.javaBase.produce_consume;
import java.util.LinkedList;
/**
 * @auther Mr.Liao
 * @date 2022/10/30 12:23
 */
public class ProducerAndConsumer {
    private Object lock = new Object();
    //定义仓库
    class WareHouse{
        //存放商品
        private LinkedList<Object> storeHouse = new LinkedList<>();
        private static final int MAX_SIZE = 5;//设置仓库最大容量

        public void produce() { // 生产,不断往storeHouse里存放商品
            try {
                synchronized (lock) {
                    while (storeHouse.size() == MAX_SIZE) {
                        System.out.println("库房已满，请生产者等待 ");
                        lock.wait(); // 让生产者的线程处于等待中
                    }
                    Object o = new Object();
                    storeHouse.add(o);
                    System.out.println(Thread.currentThread().getName() + "商品 " + o.hashCode() + " 已入库,当前商品增加至" + storeHouse.size() + "个");
                    lock.notifyAll(); // 唤醒当前锁上处于被等待状态中的线程
                    Thread.sleep((long) (Math.random() * 3000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consume() { // 消费
            try {
                synchronized (lock) {
                    while (storeHouse.size() == 0) { // 不可以用if判断
                        System.out.println("库存量为" + storeHouse.size() + ",请消费者等待，现在通知生产者去生产");
                        lock.wait(); // 让当前状态处于等待
                    }
                    Object o = storeHouse.removeFirst();
                    System.out.println(Thread.currentThread().getName() + "商品 " + o.hashCode() + " 已消费,当前商品减少至" + storeHouse.size() + "个");
                    lock.notifyAll(); // 唤醒当前对象锁的等待状态
                    Thread.sleep((long) (Math.random() * 2000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 定义生产者线程类，不断地生产产品
    class Produce extends Thread {
        private WareHouse mWarehouse = null;

        public Produce(WareHouse wh) {
            this.mWarehouse = wh;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                mWarehouse.produce();
            }
        }
    }
    // 定义消费者线程类，不断地生产产品
    class Customer extends Thread {
        private WareHouse mWarehouse = null;

        public Customer(WareHouse wh) {
            this.mWarehouse = wh;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                mWarehouse.consume();
            }
        }
    }

    public void excute() {
        WareHouse warehouse = new WareHouse();
        Produce p1 = new Produce(warehouse);
        p1.setName("生产者1号");
        p1.start();

        Produce p2 = new Produce(warehouse);
        p2.setName("生产者2号");
        p2.start();

        Customer c1 = new Customer(warehouse);
        c1.setName("消费者1号");
        c1.start();
        Customer c2 = new Customer(warehouse);
        c2.setName("消费者2号");
        c2.start();
        Customer c3 = new Customer(warehouse);
        c3.setName("消费者3号");
        c3.start();
    }
    // 执行：
    public static void main(String[] args) {
        ProducerAndConsumer p = new ProducerAndConsumer();
        p.excute();
    }


}
