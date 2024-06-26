package d1thread;

/**
 * @Description: 演示死锁问题
 * @Author Eva
 * @Date 2024/5/20
 */
public class LLockProblem {
    /*
    演示线程的死锁问题
    1、死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，
        就形成了线程的死锁
    2、说明：
        1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
        2）我们使用同步时，要避免死锁
     */
    public static void main(String[] args) {
//        举例：死锁情况
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append('a');
                    s2.append('1');
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s2){
                        s1.append('b');
                        s2.append('2');

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append('c');
                    s2.append('3');
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s1){
                        s1.append('d');
                        s2.append('4');

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }).start();
    }
}
