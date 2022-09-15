package core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AtomicTest {

    @Test
    void test() {
        AtomicInteger integer = new AtomicInteger(0);
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threadList.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(integer.getAndIncrement());
                }
            }));
        }
        threadList.stream().parallel().forEach(T -> T.start());
    }

    class Box {
        Integer integer;

        Box() {
            integer = 0;
        }

        int increment() {
            return integer++;
        }
    }

    @Test
    void test2() {
        Box box = new Box();
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threadList.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (box) {
                        System.out.println(box.increment());
                    }
                }
            }));
        }
        threadList.stream().parallel().forEach(T -> T.start());
    }
}
