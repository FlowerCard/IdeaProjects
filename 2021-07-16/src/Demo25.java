import java.util.Scanner;

public class Demo25 {
    public static void main(String[] args) {
        //判断一个数是否是完全数
        int num = 0;
        int wanShu = 0;
        Scanner inputNum = new Scanner(System.in);
        System.out.print("请输入一个数：");
        num = inputNum.nextInt();
        for (int i=1 ; i<num ; i++){
            if (num % i == 0){
                wanShu += i;
            }
        }
        if (wanShu == num){
            System.out.println("这个数是完数");
        }else {
            System.out.println("这个数不是完数");
        }
    }
}
