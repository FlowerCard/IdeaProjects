import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        //做学院评奖系统，1）如果数学成绩大于80分并且语文成绩大于80分，获奖学金500元。2）如果数学小于30并且语文小于30分，输出重修
        int mathScore;
        int languageScore;
        Scanner inputScore = new Scanner(System.in);
        System.out.print("请输入数学成绩：");
        mathScore = inputScore.nextInt();
        System.out.print("请输入语文成绩：");
        languageScore = inputScore.nextInt();
        if (mathScore >= 80 && languageScore >= 80){
            System.out.println("获得奖学金500元");
        }else if (mathScore <= 30 && languageScore <= 30){
            System.out.println("重修");
        }else {
            System.out.println("合格");
        }
    }
}
