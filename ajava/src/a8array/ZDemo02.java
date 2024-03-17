package a8array;

/**
 * @Description:
 * 数组作为参数是引用传递 ，在 doIt 方法中可以修改数组的值
 * @Author Eva
 * @Date 2024/3/17 17:02
 */

class ZDemo02 {

    // z 和 myArray指向同一个地址值
    static void doIt(int[] z){
        int temp = z[z.length - 1];
        z[z.length - 1] = z[0];
        z[0] = temp;
    }
}
