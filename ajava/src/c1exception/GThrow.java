package c1exception;

/**
 * @Description:
 * 没有文字描述，自写的：
 * 1、手动抛出异常
 *     RuntimeException：运行时异常，不需要处理
 * 2、一些方法需要处理异常是因为源码有写throw，使用时需要处理异常
 * @Author Eva
 * @Date 2024/5/17
 */
public class GThrow {
    int id;
    public static void main(String[] args) {
        GThrow gt = new GThrow();
//
        try {
            gt.regit(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void regit(int id) throws Exception {  // 父类
        if (id > 0) {
        }else {
//            手动抛出异常
//            throw new RuntimeException(); // 不需要处理异常，因为是运行时异常
//            throw new Exception(); // 需要处理异常
            throw new HCustomize();
        }
    }
}
