import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        //如果 score 值大于90，则奖励一个 Iphone 6s ，当 score 值小于等于 90 时，先判断 score 是否大于 70 ，
        // 如果 score 是介于 70--90 之间，则奖励一个红米，如果成绩小于等于 70 ，则罚做 50 个俯卧撑
        int score;
        Scanner inputScore = new Scanner(System.in);
        System.out.print("请输入成绩：");
        score = inputScore.nextInt();
        if (score > 90){
            System.out.println("奖励一个iPhone 12");
        }else if (score >70 && score <= 90){
            System.out.println("奖励一个红米");
        }else if (score <= 70){
            System.out.println("惩罚50个俯卧撑");
        }

    }
}
