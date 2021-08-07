import java.text.DecimalFormat;
import java.util.Scanner;

public class Demo09 {
    public static void main(String[] args) {
        //一位学生参加了三门不同科目的考试，计算并显示所得的总分和平均分同时显示单科所得分数
        double score1;
        double score2;
        double score3;
        double sumScores;
        String avgScores;
        Scanner inputScore = new Scanner(System.in);
        System.out.println("请输入三门课成绩：");
        score1 = inputScore.nextDouble();
        score2 = inputScore.nextDouble();
        score3 = inputScore.nextDouble();
        sumScores = score1 + score2 + score3;
        DecimalFormat df = new DecimalFormat("0.00");
        avgScores = df.format(sumScores/3.0);
        System.out.println("总分：" + sumScores + "，平均分：" + avgScores);
        System.out.println("第一科成绩：" + score1 + "\t第二科成绩：" + score2 + "\t第三科成绩：" + score3);
    }
}
