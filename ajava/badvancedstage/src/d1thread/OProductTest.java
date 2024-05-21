package d1thread;

/**
 * @Description: 经典例题：生产者、消费者问题演示；线程通信的应用
 * @Author Eva
 * @Date 2024/5/20
 */
public class OProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor p1 = new Productor(clerk);
        Constomer c1 = new Constomer(clerk);

        p1.setName("生产者：");
        c1.setName("消费者：");

        p1.start();
        c1.start();
    }

}

class Clerk{    // 代理
    private int productCount = 0;

    public synchronized void prduceProduct(){
        if (productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+"产品");
            notify();

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void consumeProduct(){
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

class Productor extends Thread{  // 生产者
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(getName()+"开始生产产品......");
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.prduceProduct();
        }
    }
}

class Constomer extends Thread{
    private Clerk clerk;
    public Constomer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        super.run();System.out.println(getName()+"开始消费产品......");
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consumeProduct();
        }
    }
}
