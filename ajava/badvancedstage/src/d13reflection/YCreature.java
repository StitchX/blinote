package d13reflection;

import java.io.Serializable;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/6/4 21:33
 */

public class YCreature<T> implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
