import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        /*
        做学生成绩系统，如果成绩大于80分，输出优秀，如果成绩大于70分并且小于80分，输出良好，如果成绩大于60分并且小于70分，输出及格，小于60分输出不及格
         */
        Scanner stuScore = new Scanner(System.in);
        System.out.print("请输入学生成绩：");
        int score = stuScore.nextInt();
        if(score > 80){
            System.out.println("优秀");
        }else if (score > 70 && score < 80){
            System.out.println("良好");
        }else if (score > 60 && score < 70){
            System.out.println("及格");
        }else {
            System.out.println("不及格");
        }
    }
}
