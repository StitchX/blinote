package project03.view;

import project03.domain.*;
import project03.service.*;

/**
 * @Description: 第十一步：UI页面实现
 * @Author Eva
 * @Date 2023/1/5 15:02 -> 2024/6/13 9:51
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void emterMainMenu(){
        boolean loopFlag = true;
        char menu=0;
        while (loopFlag){
            if (menu !='1'){
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）: ");
            menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出（Y/N）:");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }

    }
    private void listAllEmployees(){
        System.out.println("----------------------开发团队调度软件------------------------------------");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length==0){
            System.out.println("没有公司员工信息... ...");
        }else {
            System.out.println("ID\t姓名\t\t年龄\t\t工资\t\t\t职位\t\t状态\t\t 奖金\t\t股票\t\t设备信息");
            for (int i=0;i<employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------------------");
    }
    private void getTeam(){
        System.out.println("----------------------------团队成员列表-----------------------------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team==null||team.length==0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.println("TID/ID\t姓名\t\t年龄\t\t工资\t\t\t职位\t\t 奖金\t\t股票");
            for (int i=0;i<team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
    private void addMember(){
        System.out.println("----------------------------添加成员-----------------------------------------");
        System.out.print("请输入要添加的员工Id: ");
        int id = TSUtility.readInt();
        Employee emp = null;
        try {
            emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            TSUtility.readReturn();
        } catch (TeamException e) {
            System.out.println("添加失败："+e.getMessage());
        }

    }
    private void deleteMember(){
        System.out.println("----------------------------删除成员-----------------------------------------");
        System.out.print("请输入要删除员工的TID：");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除（Y/N）：");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete=='N'){
            return;
        }

        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功！");
        } catch (TeamException e) {
            System.out.println("删除失败："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.emterMainMenu();
    }
}
