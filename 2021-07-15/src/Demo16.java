import java.util.Scanner;

public class Demo16 {
    public static void main(String[] args) {
        /*
        当前小学生的成绩单由以前的百分制改为优秀、良好、合格、不合格四个等级的等级制编一程序完成分数的自动转换工作。
        转换规则如下：60分以下的为不合格；60到69分为合格；70到89分为良好；90分以上的为优秀。（提示：可以利用除法运算来使程序更简明，结合case语句）
         */
        int score = 0;
        Scanner inputScore = new Scanner(System.in);
        System.out.print("请输入成绩：");
        score = inputScore.nextInt();
//        if (score >= 90){
//            System.out.println("优秀");
//        }else if (score >=70 && score < 89){
//            System.out.println("良好");
//        }else if (score >=60 && score < 69){
//            System.out.println("合格");
//        }else {
//            System.out.println("不合格");
//        }
        switch (score/10){
            case 10:
            case 9:
                System.out.println("优秀");
                break;
            case 8:
            case 7:
                System.out.println("良好");
                break;
            case 6:
                System.out.println("合格");
                break;
            default:
                System.out.println("不合格");
                break;
        }
    }
}
