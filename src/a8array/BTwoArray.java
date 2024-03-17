package a8array;

import org.junit.Test;

/**
 * @Description:
 * 多维数组可以看成是数组的数组，比如二维数组就是一个特殊的一维数组，其每一个元素都是一个一维数组
 * @Author Eva
 * @Date 2024/3/17 16:47
 */

public class BTwoArray {

    //
    @Test
    public void demo01(){
        int[][] a4=new int[][]{{1,2},{1,2,3}}; // 二维数组
        int[][] a5=new int[2][3];
//        二维数组；依赖于内存结构的理解
        int[][] a6 = new int[2][];
        a6[0] = new int[4];  // 引用的引用
        a6[0] = new int[3];
        int[] a7[]=new int[2][];  // 也是二维数组
    }

    //    错误情况
    @Test
    public void demo02(){
//        float[][] b1 = new float[][];

    }
}

