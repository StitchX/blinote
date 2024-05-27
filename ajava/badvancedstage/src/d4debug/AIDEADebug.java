package d4debug;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/9 14:38 -> 2024/5/26 17:43
 */

public class AIDEADebug {

    public static void main(String[] args) {
        String str = null;

        StringBuffer sb1 = new StringBuffer();
        sb1.append(str);
        System.out.println(sb1.length());
        System.out.println(sb1);


//        NullPointerException
        StringBuffer sb2 = new StringBuffer(str);
        System.out.println(sb2);
    }

    /*
    怎么的debug
    1、打断点
    2、右键 debug run
    3、
        step over 一行一行往下走
        step into；红色是强制进入 查看具体实现的函数
        step out 退出函数查看
        右边的|>符号是一个断点一个断点的往下走

        点虫图标开始debug；重新debug
     */
}
