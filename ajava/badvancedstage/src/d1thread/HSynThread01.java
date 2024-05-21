package d1thread;

/**
 * @Description: 方式一：使用同步代码块解决继承Thread类的方式的线程安全问题
 * @Author Eva
 * @Date 2023/1/11 14:13 -> 2024/5/20
 */
public class HSynThread01 extends Thread {
    /*
    使用同步代码块解决继承Thread类的方式的线程安全问题

    说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
     */

    private static int ticket = 100;
    public static void main(String[] args) {
        HSynThread01 t1 = new HSynThread01();
        HSynThread01 t2 = new HSynThread01();
        HSynThread01 t3 = new HSynThread01();
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
    private static Object obj = new Object(); // 保证唯一

    @Override
    public void run() {
        while (true){
//            synchronized (obj){ // 不能用this，代表有三个对象
            synchronized (HSynThread01.class){
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
