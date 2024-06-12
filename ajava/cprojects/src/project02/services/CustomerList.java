package project02.services;

import project02.bean.Customer;

/**
 * @Description:
 * 2、
 *  CustomerList 为Customer对象的管理模块，内部用数组管理一组Custmer对象，
 *  并提供相应的添加、删除、修改、遍历方法，提供给CustomerView调用
 *  
 *  第二步：
 * CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 * 本类封装以下信息：
 *     Customer[] customers;  // 用来保存客户对象的数组
 *     int total = 0;   // 记录已保存客户对象的数量
 * 该类至少提供以下构造器和方法
 *     public CustomerList(int totalCustomer)
 *     public boolean addCustomer(Customer customer)
 *     public boolean replaceCustomer(int index, Customer cust)
 *     public boolean deleteCustomer(int index)
 *     public Customer[] getAllCustomers()
 *     public Customer getCustomer(int index)
 *     public int getTotal()
 * @Author Eva
 * @Date 2024/6/12 9:51
 */
public class CustomerList {
    private Customer[] customers;

    int total;

    /**
     * 用来初始化Customer数组的构造器
     * @param totalCustomer
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    /**
     * 将指定的客户添加在数组中
     * @param customer
     * @return true 添加成功；false 添加失败
     */
    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * 修改指定索引下的客户信息
     * @param index
     * @param cust
     * @return true 修改成功；false 修改失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if (index<0 || index>=total){
            return false;
        }
        customers[index] = cust;
        return true;
    }
    /**
     * 删除指定索引上的客户
     * @param index
     * @return true 删除成功；false 删除失败
     */
    public boolean deleteCustomer(int index){
        if (index<0 || index>=total){
            return false;
        }
        for (int i=index;i<total-1;i++){
            customers[i] = customers[i+1];
        }
//        最后有数据的元素需要置空
        customers[--total]=null;
        return true;
    }
    /**
     * 获取所有的客户信息
     * @return
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i=0;i<total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 获取指定索引位置下的客户
     * @param index
     * @return 如果找到元素则返回，没有则null
     */
    public Customer getCustomer(int index){
        if (index<0 || index>=total){
            return null;
        }
        return customers[index];
    }
    /**
     * 获取存储的客户数量
     * @return
     */
    public int getTotal(){
        return total;
    }

}
