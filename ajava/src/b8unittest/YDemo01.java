package b8unittest;

/**
 * @Description: 测试使用新加上的测试包
 * @Author Eva
 * @Date 2024/4/11 19:49
 */

public class YDemo01 {   // ctrl+shift+T
    public int factorial(int n) throws Exception{
        if (n<0){
            throw new Exception("负数没有阶乘");
        }else if (n<=1){
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }
}
