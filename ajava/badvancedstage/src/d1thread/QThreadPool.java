package d1thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 方式四：创建线程池
 * @Author Eva
 * @Date 2024/5/20
 */
public class QThreadPool implements Runnable {
    /*
    背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大
    好处：
        1、提高响应速度（减少了创建新线程的时间）
        2、降低资源消耗（重复利用线程池中线程，不需要每次都创建）
        3、便于线程管理
            corePoolSize：核心池的大小
            maximumPoolSize：最大线程数
            keepAliveTime：线程没有任务时最多保持多长时间后会终止
            ...
     */
    public static void main(String[] args) {
//        1. 提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

//        设置线程池的属性
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        System.out.println(service.getClass());
//        service1.setCorePoolSize(10);
//        service1.setKeepAliveTime(1000);

//        2. 执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new QThreadPool());
//        service.submit(); // 适用于Callable

//        关闭连接池
        service.shutdown();

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) System.out.println(Thread.currentThread().getName()+":线程"+i+"已经执行");
        }
    }
}
// 面试题：创建多线程的几种方式？
