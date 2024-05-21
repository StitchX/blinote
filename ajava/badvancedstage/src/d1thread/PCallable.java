package d1thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 创建线程的方式三：实现Callable接口--JDK5.0
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 *     1. call()可以有返回值
 *     2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 *     3. Callable是支持泛型的
 * @Author Eva
 * @Date 2023/1/13 11:03 -> 2024/5/20
 */
public class PCallable implements Callable {
    public static void main(String[] args) {
//        3. 创建接口实现类的对象
        PCallable pc = new PCallable();
//        4. 将此实现Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(pc);
//        5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
//            6. 可忽略的步骤，获取Callable方法的返回值
//            get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    //    2. 实现Callable方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2==0) System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}
