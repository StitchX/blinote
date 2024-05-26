package d2String;

import java.io.UnsupportedEncodingException;

/**
 * @Description: 字符串String与字节byte[]的转换
 * @Author Eva
 * @Date 2023/2/8 14:51 -> 2024/5/26 16:57
 */

public class EStrByte {
    /*
    String 与 byte[]之间的转换
    编码：String -->byte[]：调用String的getBytes()
    解码：byte[] -->String：调用String的构造器

    编码：字符串-->字节（看得懂 -->看不懂的二进制数据）
    解码：编码的逆过程

    说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     */

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "1i中";
        byte[] bytes1 = str1.getBytes();
        for(int i:bytes1) System.out.println(i); // 使用默认的编码集合；没有中文的话会使用ASCII码

        byte[] bytes2 = str1.getBytes("gbk"); // 使用gbk字符集进行编码
        for(int i:bytes2) System.out.println(i);

        byte[] bytes3 = {49,97};
        String str2 = new String(bytes3); // 使用默认编码集
        String str3 = new String(bytes3, "gbk"); // 使用指定编码集
        System.out.println(str2);

    }
}
