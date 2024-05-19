package c1exception;

import org.junit.Test;

/**
 * @Description:
 * Java异常处理方式：
 *     方式一：try-catch-finally
 *     方式二：throws+异常类型
 *
 * 异常处理：抓抛模式
 *     过程一：“抛”：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。并将此抛出
 *             一旦抛出对象以后，其后的代码就不再执行。
 *
 *             关于异常对象的产生：1）系统自动生成的异常对象
 *                             2）手动的生成一个异常对象，并抛出（throw）
 *     过程二：“抓”：可以理解为异常的处理方式：1）try-catch-finally  2）throws
 *
 * 二、try-catch-finally的使用
 *         try {
 *             // 可能出现异常的代码
 *         }catch (异常类型1 变量名1){
 *
 *         }catch (异常类型2 变量名2){
 *
 *         }
 *         ......
 *         finally {
 *             // 一定会执行的代码
 *         }
 * 说明：
 *     1. finally是可选的
 *     2. 使用try将可能出现异常的代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，
 *         根据此对象的类型，去catch中进行匹配
 *     3. 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。一旦处理完成，就跳出当前的
 *         try-catch结构（在没有写finally的情况）。继续执行其后的代码
 *     4. catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓
 *        catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面。否则，报错
 *     5. 常用的异常对象处理方式：1）String getMessage()      2) printStackTrace()[用的多]
 *     6. 在try结构中声明的变量，在出了try结构以后，就不能被调用
 *     7. try-catch-finally结构可以嵌套
 *
 * 体会1：使用try-catch-finally处理编译异常，是得程序在编译时就不再报错，但是运行时仍可能报错。
 *     相当于我们使用try-catch-finally 将一个编译时可能出现的异常，延迟到运行时出现。
 * 体会2：开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了。
 *     针对编译时异常，我们说一定要考虑异常的处理。
 * @Author Eva
 * @Date 2024/5/17
 */
public class CTryCatch {

    @Test
    public void test01(){
        String st1 = "123qwe";
        try {
            int in1 =Integer.parseInt(st1);
        }catch (NumberFormatException e){
            System.out.println("数值转换异常");

//            String getMessage()
//            System.out.println(e.getMessage());

            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("空指针");
        }catch (Exception e){
            System.out.println("异常");
        }

//        System.out.println(in1);
        System.out.println("hello");
    }

}
