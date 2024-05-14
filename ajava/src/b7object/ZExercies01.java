package b7object;

/**
 * @Description: 练习题，没有思考，纯写一遍
 * 编写Order类，有int型的orderID，String型的orderName
 * 相应的getter() 和setter()方法，两个参数的构造器
 * 重写父类的equal()方法：public Boolean equals(Object obj),
 * 并判断测试类中创建的两个对象是否相等
 * @Author Eva
 * @Date 2024/4/11 19:38
 */

public class ZExercies01 {
    private int orderId;
    private String orderName;
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId(){
        return orderId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof ZExercies01){
            ZExercies01 z1 = (ZExercies01) obj;
            return z1.orderId == this.orderId && this.orderName.equals(z1.orderName);
        }else {
            return false;
        }
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Order order)) return false;
//        return orderId == order.orderId && orderName.equals(order.orderName);
//    }
}

/*
Order order1 = new Order();
        Order order2 = new Order();
        order2.equals(order1);
 */
