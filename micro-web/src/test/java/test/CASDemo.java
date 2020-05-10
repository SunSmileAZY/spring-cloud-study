package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/5/7 22:02
 **/
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current"+atomicInteger.get());

//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        String a = new String("100");
        String b = new String("100");
        Integer c = new Integer("100");
        Long d = new Long("100");

        System.out.println(a.equals(b));
        System.out.println(c.equals(b));
        System.out.println(c.equals(d));


    }




}
