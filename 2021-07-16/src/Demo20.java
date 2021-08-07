import java.util.Scanner;

public class Demo20 {
    public static void main(String[] args) {
        //找出一个数的所有因子数
        int comNumber = 0;
        Scanner inputComNumber = new Scanner(System.in);
        System.out.print("请输入一个数：");
        comNumber = inputComNumber.nextInt();
        for (int i=1 ; i<comNumber ; i++){
            if (comNumber % i == 0){
                System.out.println(i);
            }
        }
    }
}
