import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        //输入一个数，判断它是否能被3、5、7整除，注意考虑同时整除的情况
        Scanner inputNumber = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int number = inputNumber.nextInt();
        if (number%3 == 0) {
            System.out.println("输入的数可以被3整除");
        }
        if (number%5 == 0) {
            System.out.println("输入的数可以被5整除");
        }
        if (number%7 == 0) {
            System.out.println("输入的数可以被7整除");
        }
        if (number%3 == 0 && number%5 == 0 && number%7 == 0)
            System.out.println("输入的数可以被3,5,7整除");
        if (number%3 != 0 && number%5 != 0 && number%7 != 0)
            System.out.println("输入的数不可以被3,5,7整除");
    }
}
