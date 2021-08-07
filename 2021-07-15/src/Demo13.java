import java.text.DecimalFormat;
import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        /*
        对一批货物征收税金（长整型）。价格在1万元及以上的货物征税5%，在5000元及以上，1万元以下的货物征税3%，在1000元及以上，
        5000元以下的货物征税2%，1000元以下的货物免税。编写一程序，读入货物价格，计算并输出税金
         */
        long money;
        double at = 0.0;
        Scanner inputMoney = new Scanner(System.in);
        System.out.print("请输入货物的价格：");
        money = inputMoney.nextLong();
        if (money >= 10000){
            at = money * 0.05;
        }else if (money >= 5000 && money < 10000){
            at = money * 0.03;
        }else if (money >= 1000 && money < 5000){
            at = money * 0.02;
        }else {
            System.out.println("1000元以下的货物免税");
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("税金为：" + df.format(at));
    }
}
