import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        //定义一个整数，计算其平方值和立方值
        int num = 0;
        Scanner inputNumber = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        num = inputNumber.nextInt();
        System.out.println(Math.pow(num,2));
        System.out.println(Math.pow(num,3));
    }
}
