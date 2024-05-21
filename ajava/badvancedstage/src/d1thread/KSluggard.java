package d1thread;

/**
 * @Description: 使用同步机制将单例模式中的懒汉式改为线程安全；笔试时写线程安全的饿汉模式
 * @Author Eva
 * @Date 2024/5/20
 */
public class KSluggard {
    private KSluggard(){}

    private static KSluggard instance = null;
    public static KSluggard getInstance(){

//        方式一：效率稍差
//        synchronized (KSluggard.class){
//            if (instance==null){
//                instance = new KSluggard();
//            }
//            return instance;
//        }
//        方式二：效率更高
        if (instance==null) {
            synchronized (KSluggard.class) {
                if (instance == null) {
                    instance = new KSluggard();
                }
            }
        }
        return instance;
    }
}
