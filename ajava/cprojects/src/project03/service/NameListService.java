package project03.service;

import project03.domain.*;
import static project03.service.Data.*;

/**
 * @Description: 第九步：负责将Data中的数据封装到Employee[]
 * @Author Eva
 * @Date 2024/6/12 16:52
 */
public class NameListService {
    private Employee[] employees;
    /**
     * 给employee及数组元素进行初始化。
     * 1. 根据项目提供的Data类构建相应大小的employee数组
     * 2. 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Desginer和
     *     Architect对象，以及相关联的Equipment子类的对象
     * 3. 将对象存于数组中
     */
    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for (int i=0;i<employees.length;i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
//            获取四个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name =EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equitment;
            double bonus;
            int stock;
            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equitment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equitment);
                    break;
                case DESIGNER:
                    equitment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equitment,bonus);
                    break;
                case ARCHITECT:
                    equitment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equitment,bonus,stock);
                    break;
            }
        }
    }
    /**
     *
     * @param i
     * @return
     */
    private Equipment createEquipment(int i) {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);
        switch (type){
            case PC:
                return new PC(EQUIPMENTS[i][1],EQUIPMENTS[i][2]);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(EQUIPMENTS[i][1],price);
            case PRINTER:
                return new Printer(EQUIPMENTS[i][1],EQUIPMENTS[i][2]);
        }
        return null;
    }

    /**
     * 获取当前所有员工
     * @return
     */
    public Employee[] getAllEmployees(){
        return employees;
    }
    /**
     * 获取指定id的员工
     */
    public Employee getEmployee(int id) throws TeamException{
        for (int i=0;i<employees.length;i++){
            if (employees[i].getId() == id){ // equits的区别，回忆 -128--127
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
