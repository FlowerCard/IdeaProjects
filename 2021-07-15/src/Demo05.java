import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入三个数，如果其中有一个值大于1000，则提示，输入的数值有大于1000的
        int num1;
        int num2;
        int num3;
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("请输入三个数：");
        num1 = inputNumber.nextInt();
        num2 = inputNumber.nextInt();
        num3 = inputNumber.nextInt();
        if (num1 > 1000 || num2 > 1000 || num3 > 1000){
            System.out.println("输入的数中有大于1000的");
        }
    }
}
