import java.text.DecimalFormat;
import java.util.Scanner;

public class Demo27 {
    public static void main(String[] args) {
        //循环录入Java课的学生成绩，统计分数大于等于 80分的学生比例(使用continue)
        int javaScores = 0;
        int stuNumber = 0;
        double count = 0.0;
        double per = 0.0;
        Scanner inputNum = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0%");
        System.out.print("请输入学生的数量：");
        stuNumber = inputNum.nextInt();
        System.out.println("请输入学生的Java成绩：");
        for (int i=0 ; i<stuNumber ; i++){
            javaScores = inputNum.nextInt();
            if (javaScores >= 80) {
                count++;
//                System.out.println(count);
            }else {
                continue;
            }
        }
        per = count / stuNumber;
//        System.out.println(per);
        System.out.println("80分及以上的学生占比为：" + (df.format(per)));
    }
}
