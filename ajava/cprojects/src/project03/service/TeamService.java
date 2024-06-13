package project03.service;

import project03.domain.*;

/**
 * @Description: 第十步：关于开发团队成员的管理：添加、删除等。
 * @Author Eva
 * @Date 2023/1/5 14:07 -> 2024/6/13 9:50
 */
public class TeamService {
    private static int counter=1; // 给memberId赋值
    private final int MAX_MEMBER = 5; // 限制开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 报错开发团队人员
    private int totel;  // 记录开发团队中实际人数

    public TeamService(){
        super();
    }
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[totel];
        for (int i=0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将指定的员工添加到开发团队中
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException{
//        成员已满，无法添加
        if (totel>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//        该员工已在本开发团队中
        if (isExit(e)){
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员
//        该员工正在休假，无法添加
        Programmer p = (Programmer) e;
        if (p.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("");
        }else if ("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }
//        团队中至少只能有一名架构师
//        团队中至少只能有两名设计师
//        团队中至少只能有三名程序员
        int numOfArch=0,numOfPro=0,numOfDes=0;
        for (int i=0;i<totel;i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }
        }
        if (p instanceof Architect){
            if (numOfArch>=1){
                throw new TeamException("团队中至少只能有一名架构师");
            }
        }else if (p instanceof Designer){
            if (numOfDes>=2){
                throw new TeamException("团队中至少只能有两名设计师");
            }
        }else if (p instanceof Programmer){
            if (numOfPro>=3){
                throw new TeamException("团队中至少只能有三名程序员");
            }
        }
//        错误的写法; 比如有一个架构师加入，架构师属于设计师的子类
//        if (p instanceof Architect && numOfArch>=1){
//            throw new TeamException("团队中至少只能有一名架构师");
//        }else if (p instanceof Designer && numOfDes>=2){
//            throw new TeamException("团队中至少只能有两名设计师");
//        }else if (p instanceof Programmer && numOfPro>=3){
//            throw new TeamException("团队中至少只能有三名程序员");
//        }

//        将p或e添加到现有的team中
        team[totel++] = p;
//        p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * 判断指定的员工是否在现有团队中
     * @param e
     * @return
     */
    private boolean isExit(Employee e) {
        for (int i=0;i<totel;i++){
            if (team[i].getId()==e.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * 从团队中删除成员
     * @param memberId
     * @throws TeamException
     */
    public void removeMember(int memberId) throws TeamException{
        int i;
        for (i=0;i<totel;i++){
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
//                team[i] = team[i+1];
            }
        }
        if (i==totel){
            throw new TeamException("未找到指定Id员工，删除失败");
        }
        for (int j=i+1;j<totel;j++){
            team[j-1]=team[j];
        }

        team[--totel]=null;
//

    }
}
