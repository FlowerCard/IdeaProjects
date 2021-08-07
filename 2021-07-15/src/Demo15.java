import java.text.DecimalFormat;
import java.util.Scanner;

public class Demo15 {
    public static void main(String[] args) {
        //某超市为了促销，规定：购物不足50元的按原价付款，超过50不足100的按九折付款，超过100元的，超过部分按八折付款。编一程序完成超市的自动计费的工作
        double money = 0.0;
        double at = 0.0;
        Scanner inputMoney = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("请输入消费金额：");
        money = inputMoney.nextDouble();
        if (money > 100){
            at = money * 0.8;
        }else if (money > 50 && money <= 100){
            at = money * 0.9;
        }else if (money <= 50){
            System.out.println("无折扣，原价付款");
        }
        System.out.println("应付款金额为：" + df.format(at));
    }
}
