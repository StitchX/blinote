package d1thread;

/**
 * @Description: 设置线程优先级
 * @Author Eva
 * @Date 2023/1/10 15:23 -> 2024/5/20
 */
public class DPriority extends Thread {
/*
线程的优先级：
    1. MAX_PRIORITY: 10
        MIN_PRIORITY: 1
        NORM_PRIORITY: 5 --->默认优先级
    2. 如何获取和设置当前线程的优先级
        setPriority(int p): 设置线程的优先级
        getPriority()：获取线程的优先级
    说明：高优先级的线程要抢占低优先级线程的CPU的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下被执行。并不意味着只有当高优先级
    的线程执行完以后，低优先级的线程才执行。

 */
public static void main(String[] args) {
    DPriority p1 = new DPriority();
    p1.setName("Thread：");
    Thread.currentThread().setName("主线程：");

    p1.setPriority(MAX_PRIORITY);
    Thread.currentThread().setPriority(MIN_PRIORITY);

    p1.start();
    for (int i = 0; i < 100; i++) {
        if (i % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + ": " + i+":"+Thread.currentThread().getPriority());
        }
    }
}

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i+":"+getPriority());
            }
        }
    }
}
