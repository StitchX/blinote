package d1thread;

/**
 * @Description: 方式二：使用同步方法解决实现Runnable接口的线程安全问题
 * @Author Eva
 * @Date 2023/1/11 14:38 -> 2024/5/20
 */
public class ISynRunnable02 implements Runnable {
    private int ticket = 100;
    public static void main(String[] args) {
        ISynRunnable02 is1 = new ISynRunnable02();
        Thread t1 = new Thread(is1);
        Thread t2 = new Thread(is1);
        Thread t3 = new Thread(is1);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    public synchronized void show(){ // 同步监视器: this
        if (ticket>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"窗口，当前票号为："+ticket);
            ticket--;
        }
    }
}
