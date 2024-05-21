package d1thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Lock锁
 * @Author Eva
 * @Date 2024/5/20
 */
public class MLock implements Runnable {
    /*
    解决线程安全问题三：Lock锁  --- JDK5.0新增
    1. 面试题：synchronized与Lock的异同？
        相同：二者都可以解决线程安全问题？
        不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
            lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
    2. 优先使用顺序：
    Lock->同步代码块（已经进入了方法体，分配了相应资源）-> 同步方法（在方法体之外）

    面试题：如何解决线程安全问题？有几种方式
     */
    private int ticket = 100;
    public static void main(String[] args) {
        MLock ml1 = new MLock();
        Thread t1 = new Thread(ml1);
        Thread t2 = new Thread(ml1);
        Thread t3 = new Thread(ml1);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();

    }
    //    1. 实例化ReentrantLock  可重入锁
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
//                2.调用锁定方法lock()：
                lock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"窗口，当前票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
//                3. 调用解锁方法unlock()
                lock.unlock();
            }

        }

    }
}

/*
> 从JDK5.0开始，Java提供了更强大的线程同步机制---通过显示定义同步锁对象来实现同步。
同步锁使用Lock对象充当
> java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。
> ReentrantLock类实现了Lock，
 */