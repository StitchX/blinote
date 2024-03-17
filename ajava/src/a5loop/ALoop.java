package a5loop;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/3/16 20:42
 */

public class ALoop {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        /*
            Java5 中引入了一种主要用于数组的增强型 for 循环
         */
        for (int i:a){
            System.out.println(i);
        }

        for (int i=0;i<10;i++){
            System.out.println("");
        }

        while (a[0]==1){
            a[0] = 9;
        }
        do {
            System.out.println(a[1]);
            a[1] = 9;
        }while (a[1]==2);

//        ----------------------------------------------------
        for (;;){
            System.out.println("一直循环");
            break;
        }
        while (true){
            System.out.println("一直循环");
        }


    }
}
