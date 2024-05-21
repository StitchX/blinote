package d1thread;

/**
 * @Description: 使用同步方法处理继承Thread类的方式中的线程安全问题
 * @Author Eva
 * @Date 2023/1/11 14:38 -> 2024/5/20
 */
public class JSynThread02 extends Thread {
    /*
    使用同步代码块解决继承Thread类的方式的线程安全问题
    说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
     */

    private static int ticket = 100;
    public static void main(String[] args) {
        JSynThread02 t1 = new JSynThread02();
        JSynThread02 t2 = new JSynThread02();
        JSynThread02 t3 = new JSynThread02();
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

    public synchronized static void show(){ //同步监视器: JSynThread02.class
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

/*
其它学习内容：
    一直不接受线程同步可以解决死锁的概念；在网络上寻找底层原理

synchronized的作用：保证了原子性、可见性、有序性
synchronized是在软件层面依赖于JVM，而j.u.c下的lock是依赖于硬件层面。
Synchronized底层原理分为2中：对象锁和方法锁，即修饰对象和修饰方法

ynchronized底层语义原理
    简单理解：            -csdn 网站一
    1、synchronized 修饰代码块-指定锁对象：
        每个对象在存储时都有对应的锁状态字段，使用了synchronized 关键字修饰后，对应的代码块在底层执行时，会拿锁作用的对象头部的锁状态标识，
        如果未上锁，则添加锁修改为已锁状态，使用完后释放锁，从而达到同步的效果。
    2、synchronized 修饰方法：
        每个方法在方法表中存储时有是否是同步方法的标识 ACC_SYNCHRONIZED，使用synchronized 关键字修饰后，对应的方法在执行时，也会拿锁作
        用的对象头部的锁状态标识，如果未上锁，则添加锁修改为已锁状态，使用完后释放锁，从而达到同步的效果。

    本质上还是 java 对象中存储了关于锁的标识，才致使java中任意对象均可作为锁。

    其它网站细节理解：      -稀土掘金 网站二
    无论是实例对象（包括实例this和方法）还是类对象。在JVM中，每个对象都是由三部分组成的：对象头、实例数据、数据填充
                        | 存储对象自身的运行时数据（Mark Word）：哈希码、GC分代年龄、锁状态标识、线程持有的锁、偏向线程ID、偏向时间戳
              |   对象头 | 类型指针
              |         | 若为对象数组，还应有记录数字长度的数据
        对象   |  实例数据
              |  对齐填充
    实例数据：存放类的属性数据信息，包括父类的属性信息；
    对齐填充：由于虚拟机要求，对象起始地址必须是8字节的整数倍。填充数据不是必须存在的，仅仅是为了字节对齐；
    对象头：Java对象头一般占有2个机器码（在32位虚拟机中，1个机器码等于4字节，也就是32bit，在64位虚拟机中，1个机器码是8个字节，也就是64bit），
            但是，如果对象是数组类型，则需要3个机器码，因为JVM虚拟机可以通过Java对象的元数据信息确定Java对象的大小，但是无法从数组的元数据来
            确认数组的大小，所以用一块来记录数组长度


     网站三：博客园 https://www.cnblogs.com/aspirant/p/11470858.html
     Synchronized是通过对象内部的一个叫做 监视器锁（Monitor）来实现的。但是监视器锁本质又是依赖于底层的操作系统的Mutex Lock来实现的。而操作
     系统实现线程之间的切换这就需要从用户态转换到核心态，这个成本非常高，状态之间的转换需要相对比较长的时间，这就是为什么Synchronized效率低的原
     因。因此，这种依赖于操作系统Mutex Lock所实现的锁我们称之为 “重量级锁”。

     解决多线程的并发安全问题，java无非就是加锁，具体就是两个方法
        (1) Synchronized(java自带的关键字)
        (2) lock 可重入锁 (可重入锁这个包java.util.concurrent.locks 底下有两个接口，分别对应两个类实现了这个两个接口：
            (a)lock接口, 实现的类为：ReentrantLock类 可重入锁;
            (b)readwritelock接口，实现类为：ReentrantReadWriteLock 读写锁)
        也就是说有三种：
            （1）synchronized 是互斥锁；
            （2）ReentrantLock 顾名思义 ：可重入锁
            （3）ReentrantReadWriteLock :读写锁
    读写锁特点：
        a）多个读者可以同时进行读
        b）写者必须互斥（只允许一个写者写，也不能读者写者同时进行）
        c）写者优先于读者（一旦有写者，则后续读者必须等待，唤醒时优先考虑写者）
            总结来说，Lock和synchronized有以下几点不同：
        1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
        2）当synchronized块结束时，会自动释放锁，lock一般需要在finally中自己释放。synchronized在发生异常时，会自动释放线程占有的锁，
        因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在
        finally块中释放锁；
        3）lock等待锁过程中可以用interrupt来终端等待，而synchronized只能等待锁的释放，不能响应中断。
        4）lock可以通过trylock来知道有没有获取锁，而synchronized不能；
    5. 当synchronized块执行时，只能使用非公平锁，无法实现公平锁，而lock可以通过new ReentrantLock(true)设置为公平锁，从而在某些场景
       下提高效率。
    6、LLock可以提高多个线程进行读操作的效率。（可以通过readwritelock实现读写分离）
    7、synchronized 锁类型 可重入 不可中断 非公平 而 lock 是： 可重入 可判断 可公平（两者皆可）
        在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），此时Lock的性能要远远优
        于synchronized。
                所以说，在具体使用时要根据适当情况选择

 */
