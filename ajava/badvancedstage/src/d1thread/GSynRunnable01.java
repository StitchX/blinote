package d1thread;

/**
 * @Description: 线程的同步（synchronization[ˈsɪŋkrənaɪzd]），解决线程安全问题
 * @Author Eva
 * @Date 2023/1/10 17:28 -> 2024/5/20
 */
public class GSynRunnable01 implements Runnable {
    /*
    三个卖票窗口，总票数为100张，使用实现Runnable接口的方式
    1、问题：卖票过程中，出现了重票、错票 -->出现了线程安全问题
    2、问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
    3、如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket时，其他线程才可以
        开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变
    4、在Java中，我们通过同步机制，来解决线程的安全问题
        方式一：同步代码块
            synchronized (同步监视器){
            // 需要被同步的代码
            }
            说明：1. 操作共享数据的代码，即为需要被同步的代码 -->不能包含代码多了，也不能包含代码少了
                 2. 共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
                 3. 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
                    要求：多个线程必须共用一把锁

                补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
        方式二：同步方法
            如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
    5、同步的方式，解决了线程的安全问题。 -- 好处
        操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。-->局限性

     */

    private int ticket = 100;
    public static void main(String[] args) {
        GSynRunnable01 gt1 = new GSynRunnable01();
        Thread t1 = new Thread(gt1);
        Thread t2 = new Thread(gt1);
        Thread t3 = new Thread(gt1);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
    Object obj = new Object(); // 多个线程必须共用一把锁；写在在方法外

    @Override
    public void run() {
        while (true){
//            synchronized (obj){
            synchronized (this){ // GSynRunnable01.class
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
            }

        }
    }
}
