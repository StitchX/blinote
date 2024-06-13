package project03.junit;

import org.junit.Test;
import project03.domain.Employee;
import project03.service.NameListService;
import project03.service.TeamException;

/**
 * @Description: 第十二步：对NameListService类进行测试；也可以NameListService写完遍历元素之后
 * @Author Eva
 * @Date 2024/6/13 9:53
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployee(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i=0;i<employees.length;i++){
            System.out.println(employees[i]);
        }
    }
    @Test
    public void testGetEmployee() throws TeamException {
        NameListService service = new NameListService();
        int id = 27;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }

    }
}
