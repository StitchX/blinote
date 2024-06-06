package project01;

import java.util.Scanner;

/**
 * @Description: 家庭收支记账软件
 * @Author Eva
 * @Date 2023/1/6 11:13 -> 2024/6/6 16:04
 */
public class Demo {
    public static void main(String[] args) {
        double sz;
        double money = 0;
        String xx;
        int i;
        String detail = "收支\t账户金额\t收支金额\t说明";
        while (true) {
            Scanner scn = new Scanner(System.in);
            System.out.println("------------家庭收支记账明细-------------");
            System.out.println("             1 收支明细               ");
            System.out.println("             2 登记收入               ");
            System.out.println("             3 登记支出                ");
            System.out.println("             4 退   出               ");
            System.out.print("            请选择<1-4>：");
//            break;

            if (scn.hasNextInt()) {
                i = scn.nextInt();
                if (i == 1) {

                } else if (i == 2) {
                    System.out.print("本次收入金额：");
                    sz = Double.parseDouble(scn.next());
                    System.out.print("本次收入说明：");
                    scn.hasNext();
                    xx = String.valueOf(scn.next());
                    money += sz;
//                    遇到的问题，\t 的表示方法不同，所以前面加了个 ' '
                    detail = detail+"\n收入\t "+ money +"\t"+sz+' '+"\t"+xx;
                } else if (i == 3) {
                    System.out.print("本次支出金额：");
                    sz = Double.parseDouble(scn.next());
                    System.out.print("本次支出说明：");
                    xx = String.valueOf(scn.next());
                    money -= sz;
                    detail = detail+"\n支出\t "+ money +"\t"+sz+' '+"\t"+xx;
                } else if (i == 4) {
                    System.out.println("--------------已退出---------------");
                    break;
                } else {
                    System.out.println("----------输入错误请重新输入---------");
                    continue;
                }

            } else {
                System.out.println("---------输入错误请重新输入--------");
                continue;
            }

            System.out.println("--------- --当前收支明细记录--------------");
            System.out.println(detail);
            System.out.println();
            System.out.println("----------------------------------------");

        }
    }
}
