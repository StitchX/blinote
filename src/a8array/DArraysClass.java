package a8array;

import java.util.Arrays;

/**
 * @Description:
 * Arrays 类
 *     java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。
 * 具有以下功能：
 *     给数组赋值：通过 fill 方法。
 *     对数组排序：通过 sort 方法,按升序。
 *     比较数组：通过 equals 方法比较数组中元素值是否相等。
 *     查找数组元素：通过 binarySearch 方法能对排序好的数组进行二分查找法操作。
 * @Author Eva
 * @Date 2024/3/17 16:58
 */

public class DArraysClass {
    public static void main(String[] args) {
        int[] a={1,9,3,4,5};
        int[] b={1,2,3,5};
        String str = Arrays.toString(a);  //将数组array转换成字符串
        System.out.println(str);  //[1, 9, 3, 4, 5]
        Arrays.sort(a);  // 排序
        System.out.println(a[1]);  // 3
        Arrays.fill(a,10);  // 全部赋值为10
        System.out.println(a[0]);  //10

        System.out.println(Arrays.equals(a,b));  //比较两个数组

        int i=Arrays.binarySearch(a,5);  // 二分法查找
        System.out.println(i); // 查找特定元素下标
    }
}
