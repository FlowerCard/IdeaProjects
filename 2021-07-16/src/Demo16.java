import java.text.DecimalFormat;

public class Demo16 {
    public static void main(String[] args) {
        //本金10000元存入银行，年利率是千分之三，每过1年，将本金和利息相加作为新的本金。计算5年后，获得的本金是多少？(用double存储)
        double money = 10000.0;
        for (int i=0 ; i<5 ; i++){
            money = money + money * 0.003;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("5年后，本金为：" + df.format(money));
    }
}
