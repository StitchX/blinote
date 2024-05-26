package d2String;

/**
 * @Description: String与char[]之间的转换
 * @Author Eva
 * @Date 2023/2/8 14:44 -> 2024/5/26 16:19
 */

public class DStrChar {
    /*
    String --> char[]：调用String的toCharArray()
    char[] --> String：调用String的构造器
     */
    public static void main(String[] args) {
        String str1 = "34er";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] c1 = new char[]{'1','2','3','4'};
        String str2 = new String(c1);
        System.out.println(str2);

//        问题：把字符串 "wertyuiop" 的倒数5个字符倒叙排列
    }
}
