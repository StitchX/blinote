package project03.service;

/**
 * @Description: 第八步：创建添加数据和定义枚举类
 * @Author Eva
 * @Date 2024/6/12 16:30
 */
public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;
    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

//  Employee         : 10, id, name, age, salary
//  Programmer       : 11, id, name, age, salary
//  Desinger         : 12, id, name, age, salary, bonus奖金
//  Architect        : 13, id, name, age, salary, bonus, stock股票

    public static final String[][] EMPLOYEES={
            {"10","1","马云","22","3000"},
            {"13","2","马化腾","32","18000","15000","2000"},
            {"11","3","李彦宏","23","7000"},
            {"11","4","刘强东","24","7300"},
            {"12","5","雷军","28","10000","5000"},
            {"11","6","任志强","22","6800"},
            {"12","7","柳传志","22","10800","5200"},
            {"13","8","杨元庆","30","19800","15000","2500"},
            {"12","9","史玉柱","22","9800","5500"},
            {"11","10","丁磊","22","6600"},
            {"11","11","张朝阳","25","7100"},
            {"12","12","杨致远","27","9600","4800"}
    };

//  如下EQUIPMENTS数组于上面的EMPLOYEES数据元素一一对应
//  PC       : 21, model, display
//  NoteBook : 22, model, price
//  Printer  : 23, model, type

    public static final String[][] EQUIPMENTS={
            {},
            {"22","联想T4","6000"},
            {"21","戴尔","NEC17寸"},
            {"21","戴尔","三星17寸"},
            {"23","佳能2900","激光"},
            {"21","华硕","三星17寸"},
            {"21","华硕","三星17寸"},
            {"23","爱普生20K","针式"},
            {"22","惠普m6","5800"},
            {"21","戴尔","NEC17寸"},
            {"21","华硕","三星17寸"},
            {"22","惠普m6","5800"}
    };
}
