package a8array;

/**
 * @Description:
 *  主要考引用数据类型的值传递
 * @Author Eva
 * @Date 2024/3/17 17:01
 */

public class Exercise01 {
    public static void main ( String[] args ){

        int[] myArray = {1, 2, 3, 4, 5};
        ZDemo01.doIt( myArray );

        for(int j=0; j<myArray.length; j++)
            System.out.print( myArray[j] + " " ); // 1 2 3 4 5

        System.out.println("下面是地址传递,指向同一个对象");
        ZDemo02.doIt(myArray);
        for(int i:myArray){
            System.out.print(i+" "); // 5 2 3 4 1
        }
    }

}
