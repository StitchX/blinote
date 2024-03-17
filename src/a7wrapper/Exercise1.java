package a7wrapper;

import java.util.Scanner;
import java.util.Vector;

/**
 * @Description:
 * 包装类Wrapper的使用练习：
 *
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度
 * 而向量java.util.Vector可以根据需要动态伸缩。
 *
 * 创建Vector对象：Vector v = new Vector();
 * 给向量添加元素：v.addElement(Object obj); // obj必须是对象
 * 取出向量中的元素：Object obj = v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A；20：B；30；C
 * @Author Eva
 * @Date 2024/3/17 16:29
 */

public class Exercise1 {
    public static void main(String[] args) {
        int max=0;
//        1、实例化Scanner，用于从键盘获取学生成绩
        Scanner scn = new Scanner(System.in);
//        2、创建Vector对象：Vector v = new Vector()；相当于原来的数组
        Vector v = new Vector();
//        3、通过for(;;)或while(true)方式，给Vector中添加数组
        while (true){
            int score = scn.nextInt();
            //        3.2 当输入是负数时，跳出循环
            if (score<-1){
                break;
            }
            if (score>100){
                System.out.println("输入错误");
                continue;
            }
            //        3.1 添加操作 ：：v.addElement(Object obj)
//            java5.0之前
//            Integer inScore = new Integer(score);
//            v.addElement(inScore); // 多态

//            java5.0之后，自动类型转换
            v.addElement(score);  // 自动装箱

            //        4、获取学生成绩的最大值
            if (max<score){
                max = score;
            }
        }

//        5、遍历Vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级。
        for (int i = 0; i < v.size(); i++){
            Object obj = v.elementAt(i);

//            jdk5.0之前
//            Integer inScore = (Integer) obj;
//            int score = inScore.intValue();

//            jdk5.0之后
            int score = (int)obj; // 没理解到这操作
//            现在理解了，obj是一个object类，需要先把obj转换为Integer类，然后拆箱
//            可以参考：b6polymorphism.BInstanceof向下转型

//            后面判断等级，略过
        }

    }

}

