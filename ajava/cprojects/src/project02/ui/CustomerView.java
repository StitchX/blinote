package project02.ui;

import project02.bean.Customer;
import project02.services.CustomerList;
import project02.util.CMUtility;

/**
 * @Description: CustomerView为主模块，负责菜单的显示和处理用户操作
 * CustomerView 为主模块，负责菜单的显示和处理用户操作
 * 本类封装以下信息：
 *     CustomerList customerList = new CustomerList(10);
 *     创建最大包含10个客户对象的CustomerList 对象，供以下各成员方法使用。
 * 该类至少提供以下方法：
 *     public void enterMainMenu()
 *     public void addNewCustomer()
 *     public void modifyCustomer()
 *     public void deleteCustomer()
 *     public void listAllCustomer()
 *     public static void main(String[] args)
 * @Author Eva
 * @Date 2024/6/12 16:11
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);
    public CustomerView(){
        Customer customer = new Customer("qq",'女',18,"18888888888","gm@gmail.com");
        customerList.addCustomer(customer);
    }


    /**
     * 显示客户信息管理软件方法
     */
    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("------------客户信息管理软件-------------");
            System.out.println("             1 添加客户               ");
            System.out.println("             2 修改客户               ");
            System.out.println("             3 删除客户                ");
            System.out.println("             4 客户列表               ");
            System.out.println("             5 退   出               \n");
            System.out.print("       请选择<1-5>：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）:");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }

            }
        }


    }

    /**
     * 添加用户操作
     */
    public void addNewCustomer(){
        System.out.println("--------------添加客户--------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

//        将上诉数据封装到对象中
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSucess = customerList.addCustomer(customer);
        if (isSucess){
            System.out.println("---------------添加成功-------------");
        }else {
            System.out.println("---------客户目录已满，添加失败-------------");
        }

    }
    /**
     * 修改客户操
     */
    public void modifyCustomer(){
        System.out.println("--------------修改客户-----------------");
        Customer cust;
        int number;
        for (;;){
            System.out.print("请选择待修改客户编号（-1退出）：");
            number = CMUtility.readInt();
            if (number == -1){
                return;
            }
            cust = customerList.getCustomer(number-1);
            if (cust == null){
                System.out.println("无法找到指定客户!");
            }else {  // 找到了相应的客户
                break;
            }

        }
        //修改客户信息
        System.out.print("姓名（"+cust.getName()+"）：");
        String name = CMUtility.readString(10,cust.getName());
        System.out.print("性别（"+cust.getName()+"）：");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄（"+cust.getAge()+"）：");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（"+cust.getPhone()+"）：");
        String phone = CMUtility.readString(10,cust.getPhone());
        System.out.print("邮箱（"+cust.getEmail()+"）：");
        String email = CMUtility.readString(10,cust.getEmail());

        Customer newCust = new Customer(name,gender,age,phone,email);

        boolean isRepalaced = customerList.replaceCustomer(number-1,newCust);
        if (isRepalaced){
            System.out.println("------------------修改完成------------------");
        }else {
            System.out.println("-------------------修改失败------------------");
        }

    }

    /**
     * 删除客户操作
     */
    public void deleteCustomer(){
        System.out.println("---------------------删除客户-------------------------");
        Customer cust;
        int number;
        for (;;){
            System.out.print("请选择待删除客户编号（-1退出）：");
            number = CMUtility.readInt();
            if (number == -1){
                return;
            }
            cust = customerList.getCustomer(number-1);
            if (cust == null){
                System.out.println("无法找到指定客户!");
            }else {  // 找到了相应的客户
                break;
            }
        }
        boolean isDelete = customerList.deleteCustomer(number-1);//replaceCustomer(number-1,newCust);
        if (isDelete){
            System.out.println("------------------删除完成------------------");
        }else {
            System.out.println("-------------------删除失败------------------");
        }

    }

    /**
     * 展示客户列表
     */
    public void listAllCustomer(){
        System.out.println("-----------------客户列表----------------------");
        int total = customerList.getTotal();
        if (total == 0){
            System.out.println("没有客户记录");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t 邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i=0;i<custs.length;i++){
                Customer cust = custs[i];
                System.out.println(i+1 + "\t" +cust.getName()+"\t"+cust.getGender()
                        + "\t" +cust.getAge()+ "\t" +cust.getPhone()+ "\t" +cust.getEmail());
            }
        }


        System.out.println("-----------------客户列表完成----------------------");

    }
    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
