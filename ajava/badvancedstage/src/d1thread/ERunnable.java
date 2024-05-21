package d1thread;

/**
 * @Description: 第二种创建多线程的方式
 * @Author Eva
 * @Date 2023/1/10 15:40 -> 2024/5/20
 */
public class ERunnable implements Runnable {
    /*
    创建多线程的方式二：实现Runnable接口
    1、创建一个实现类Runnable中的抽象方法：run()
    2、实现类去实现Runnable中的抽象方法：run()
    3、创建实现类的对象
    4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
    5、通过Thread类的对象调用start()

    比较创建线程的两种方式：
    开发中：优先选择：实现Runnable接口的方式
    原因：1、实现的方式没有类的单继承性的局限性
         2、实现的方式更适合来处理多个线程有共享数据的情况
    联系：public class Thread implements Runnable
    相同点：两种方式都需要重写run()，将线程要执行的逻辑声明在run()中。
     */

    private int ticket = 100;
    //    目前有线程安全问题，之后讲解
    public static void main(String[] args) {
        ERunnable er1 = new ERunnable();
        Thread t1 = new Thread(er1);
        Thread t2 = new Thread(er1);
        Thread t3 = new Thread(er1);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start(); // 为啥可以使用Thread里的run方法，看源码
        t2.start();
        t3.start();

    }

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"窗口，当前票号为："+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
