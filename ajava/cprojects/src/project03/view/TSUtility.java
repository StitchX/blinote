package project03.view;

import java.util.Scanner;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/6/12 16:29
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 用于界面菜单的选择。改方法读取键盘，如果用户键入1-5中的任意字符，则方法返回。返回值为用户所选
     */
    public static char readMenuSelection(){
        char c;
        while (true){
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if (c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5'){
                System.out.print("选择错误，请重新输入：");
            }else break;
        }
        return c;
    }

    /**
     * 该方法提示并等待，直到用户回车键后撤回
     */
    public static void readReturn(){
        System.out.println("按回车键继续...");
        readKeyBoard(100,true);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
     */
    public static int readInt(){
        int n;
        for (;;){
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 用于确认选择的输入，该方法从键盘读取‘Y’ ‘N'，并将其作为方法的返回值
     */
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str = readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if (c == 'Y' || c=='N'){
                break;
            } else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }


    private static String readKeyBoard(int limit,boolean blankReturn){
        String line = "";
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            if (line.length() == 0){   // 提供必填校验
                if (blankReturn) return line;
                else continue;
            }
            if (line.length()<1||line.length()>limit){   // 提供长度校验
                System.out.print("输入长度（不大于"+limit+")错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
