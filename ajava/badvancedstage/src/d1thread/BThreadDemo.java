package d1thread;

/**
 * @Description: 1、创建一个线程的步骤；2、可能遇到的两个问题
 * @Author Eva
 * @Date 2023/1/6 14:23 -> 2024/5/20
 */
public class BThreadDemo extends Thread{// 1、
    /*
    多线程的创建，方式一：继承于Thread类
    1. 创建一个继承于Thread类的子类
    2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
    3. 创建Thread类的子类的对象
    4. 通过此对象调用start()
        两个作用：
            1）启动当前线程
            2）调用当前线程的run()
     */

    //    例一：遍历100以内的所有偶数
    @Override
    public void run() { // 2、
        for (int i=1;i<100;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }

    //    一般main方法在新class中
    public static void main(String[] args) {

        BThreadDemo bt1 = new BThreadDemo(); // 3、
        bt1.start(); // 4、启动当前线程;调用当前线程的run()

//        如下操作仍然是在main线程中执行的
        for (int i=1;i<30;i++){
            System.out.println(Thread.currentThread().getName());
        }

//        两个问题：
//        问题一：我们不能通过直接调用run()的方式启动线程；没有创建新线程
//        bt1.run();

//        问题二：再启动一个线程，遍历100以内的偶数，不可以还让已经start()的线程去执行。
//          会报IllegalThreadStateException（源码这么写的）
//        bt1.start();
//        我们需要重写创建一个线程的对象
//        B1ThreadDemo bt2 = new B1ThreadDemo();
//        bt2.start();

    }
    /*
    解释下执行步骤：
    1、主线程：调用main方->B1ThreadDemo bt1 = new B1ThreadDemo()
    2、主线程：bt1.start();创建一个新线程
    3、主线程：System.out.println("*");
    4、同时新线程：System.out.println(i);
     */
}
