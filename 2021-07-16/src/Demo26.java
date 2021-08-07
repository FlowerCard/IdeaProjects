import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo26 {
    public static void main(String[] args) {
        //循环录入某学生5门课的成绩并计算平均分，如果某分数录入为负，停止录入并提示录入错误（使用break）
        List<Double> scores = new ArrayList<>();
        double sum = 0.0;
        double avg = 0.0;
        Scanner inputScores = new Scanner(System.in);
        System.out.println("请输入学生5门课成绩：");
        for (int i=0 ; i<5 ; i++){
            scores.add(inputScores.nextDouble());
            if (scores.get(i) < 0){
                System.out.println("分数不能为负数");
                break;
            }
            sum+=scores.get(i);
            avg = sum/scores.size();
        }
        System.out.println("学生5门课的平均分为：" + avg);
    }
}
