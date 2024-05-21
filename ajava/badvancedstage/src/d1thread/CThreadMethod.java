package d1thread;

/**
 * @Description: thread中的常用方法
 * @Author Eva
 * @Date 2023/1/6 14:40 -> 2024/5/20
 */
public class CThreadMethod extends Thread{
    public CThreadMethod(){
    }
    /*
    测试Thread中的常用方法：
    1、start()：启动当前线程；调用当前线程的run()
    2、run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
    3、currentThread()：静态方法，返回执行当前代码的线程
    4、getName()：获取当前线程的名字
    5、setName()：设置当前线程的名字；两种修改名称的方式
    6、yield()：释放当前CPU的执行权
    7、join()：在线程A中调用线程B的join()，此时线程A就进入阻塞状态，知道线程B执行完之以后，线程A才结束阻塞状态。
    8、stop()：已过时。当执行此方式时，强制结束当前线程。
    9、sleep(long millitime)：让当前线程”睡眠“指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态
    10、isAlive()：判断当前线程是否存活
     */

    //    setName；两种修改名字的方式
//    getName()：获取当前线程的名字
    public CThreadMethod(String name){
        super(name);   // 修改名字的第二种方式
    }

    //    join()
    public static void main(String[] args){
        CThreadMethod ct1 = new CThreadMethod();
//        修改名称一：
        ct1.setName("线程一：");

//        修改名称的方式二：
//        CThreadMethod ct1 = new CThreadMethod("Thread1: ");
//        ct1.start();

        Thread.currentThread().setName("主线程：");
        for (int i = 0; i < 100; i++) {
            if (i%2==0) System.out.println(Thread.currentThread().getName()+": "+i);
            if (i==20) { //
                try {
                    ct1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(ct1.isAlive());
        }
    }

    //    yield()
//    sleep()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (i%20==0) this.yield();
        }
    }
}
