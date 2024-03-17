package a8array;

import org.junit.Test;

/**
 * @Description:
 * 1、声明、初始化
 * 2、调用指定位置元素
 * 3、获取数组长度
 * 4、遍历数组元素
 * 5、数组元素的默认初始化值(数字：0，0.0 ; 布尔：false; String：null; char：0或'\\u000' ;
 *                         引用数据类型 String:null)
 * 6、数组的内存解析
 * 堆栈的概念，引用计数算法，垃圾回收机制
 *
 *
 * 二维数组：
 * 5、数组元素的默认初始化值
 *     外层元素为地址值a[0]  = [I@15dbs7457  ； 内层未初始化则为 null
 *     内层元素和一维一致a[0][0] = null
 * @Author Eva
 * @Date 2024/3/17 16:42
 */

public class AArray {

    //    1. 声明、初始化
    double[] a3={1,2,6,4};
    @Test
    public void demo01(){
//         声明
        double[] a1; // 首选的方法
        double a2[]; //Java中采用是为了让 C/C++ 程序员能够快速理解java语言

//        创建数组
        a1 = new double[10];  // 动态初始化：在创建数组时只指定数组长度，后续通过索引赋值
//        数组的默认初始化：数组是引用类型，它的元素相当于类的实例变量，因此数组分配空间后，
//        每个元素也被按照实例变量同样的方式被隐式初始化

        a1[0]=1.0;
        a2 = new double[]{1.2,3.4,5.6}; // 静态初始化：在创建数组时直接指定数组元素


    }

    //  2. 调用指定位置元素
    @Test
    public void demo02(){
        a3[0]=1.2;
        a3[1]=2.1;
        System.out.println(a3[1]);   //2.1
        System.out.println(a3.length);  //4
        System.out.println(a3[2]); //6.0
    }

    //    3. 数组的复制
    @Test
    public void demo03(){
        int[] array1,array2;
        array1 = new int[]{1,2,3,4,5};
        array2 = array1;  // 复制的索引

//    4. 复制
        array2 = new int[array1.length];
        for (int i = 0;i<array1.length;i++){
            array2[i] = array1[i];
        }
    }

    //    5. 数组作为返回值
    public int[] arraydemo2(){
        int[] aa = new int[]{11,2,23,4,5,6};
        return aa;
    }

    //    6. 数组作为参数
    public void arraydemo(int[] i){
//        7. for增强
        for (int j:i){
            System.out.println(j);
        }
    }

}

