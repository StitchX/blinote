package a5loop;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/3/16 20:44
 */

public class CContinue {
    public static void main(String[] args) {
        label: for (int j=0;j<10;j++){
            for (int k=0;k<10;k++){
                if (j==3){
                    continue label; // 指定结束循环 label
                }
            }
        }
    }
}
