package a7wrapper;

/**
 * @Description:
 * Character 类用于对单个字符进行操作。
 * Character 类在对象中包装一个基本类型 char 的值
 * @Author Eva
 * @Date 2024/3/16 21:35
 */

public class BCharacter {
    public static void main(String[] args) {
        char a='a';
        char b='\u039A';
        char[] charArray={'a','b','c','d','e'};
        System.out.println(b);
        for (char i:charArray){
            System.out.print(i);
        }

//        将一个char类型的参数传递给需要一个Character类型参数的方法时，
//        那么编译器会自动地将char类型参数转换为Character对象。 这种特征称为装箱，反过来称为拆箱。
        Character ch1 = new Character('e');
        Character ch2 = 'f';
        char c = ch2; // 拆箱

//        一些方法
        System.out.println(Character.isLetter(ch1));  //true
        System.out.println(Character.isDigit(ch2));  // false
        System.out.println(Character.isWhitespace(' '));  //true
        System.out.println(Character.isUpperCase(c)); //false

    }
}
