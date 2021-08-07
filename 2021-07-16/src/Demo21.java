import java.util.Scanner;

public class Demo21 {
    public static void main(String[] args) {
        //输入一个数，判断这个数是否是素数
        int num = 0;
        boolean a = true;
        Scanner inputNum = new Scanner(System.in);
        System.out.print("请输入一个数：");
        num = inputNum.nextInt();
        /*
        大于1的自然数，只有1和它本身能整除，其他数不能整除
         */
        for (int i=2 ; i<num ; i++){
            //如果输入的数能被整除，a变成false。并结束这个循环
            if (num % i == 0){
                a = false;
                break;
            }
        }
        if (a == true){
            System.out.println("这个是素数");
        }else {
            System.out.println("这不是个素数");
        }
    }
}
