package a6condition;

/**
 * @Description: 条件语句
 * @Author Eva
 * @Date 2024/3/16 20:58
 */

public class ACondition {

    public static void main(String[] args) {
        int a=2;
        if(a<8){
            System.out.println(a);
        }else if(a>10){
            if (a>19){
                System.out.println(a);
            }else {
                System.out.println(a);
            }
        }else {
            System.out.println(a);
        }

        switch (a){
            case 1:
                System.out.println('a');break;
            case 2:
                System.out.println('b');
            case 3:
                System.out.println('c');break;
            default:
                System.out.println('d');
        }


    }
}
