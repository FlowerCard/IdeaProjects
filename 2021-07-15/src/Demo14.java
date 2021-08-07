import java.util.Scanner;

public class Demo14 {
    public static void main(String[] args) {
        //输入3个整数，将其中最小的数输出
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        Scanner inputNum = new Scanner(System.in);
        System.out.println("请输入三个整数");
        num1 = inputNum.nextInt();
        num2 = inputNum.nextInt();
        num3 = inputNum.nextInt();
        System.out.println(Math.min(Math.min(num1,num2),num3));
    }
}
