package d1thread;

/**
 * @Description: 线程的生命周期
 * @Author Eva
 * @Date 2023/1/10 16:51 -> 2024/5/20
 */
public class FLifeCycle {
    //    三次按shift--输入thread -- 勾选includ -- 查找：State { -- 看下源码，生命周期的几种状态

    /*
    Java语言使用thread类及其子类的对象来表示线程，在它的一个完整的生命周期中通常需要经历如下的五种状态：
        新建：当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建状态
        就绪：处于新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已具备了运行的条件，只是没分配到CPU资源
        运行：当就绪的线程被调度并获得CPU资源时，便进入运行状态，run()方法定义了线程的操作和功能
        阻塞：在某种特殊情况下，被人为挂起或执行输入输出操作时，让出CPU并临时中止自己的执行，进入阻塞状态
        死亡：线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束
     */
    /*

        图示：
                 sleep()时间到  ------>  阻塞 <------- sleep(long time)
                    join()结束 |                    | join()
                   获取同步锁   |                    |  等待同步锁
        notify()/notifyAll()  |                    |  wait()
                     resume() |                    |  suspend()
                              |     获取CPU执行器    |
            新建------------->就绪<================>运行---------->死亡
                 调用start()      失去CPU执行权或yield()  执行完run()
                                                       调用线程的stop()
                                                       出现Error/Exception
                                                       且没处理
     */
    /*

    前图示：
                       <-  [阻塞状态]  <-
                  阻塞解除             致阻塞事件
    创建->start()->[就绪状态]--->调度--->[运行状态]->终止
     */
}
