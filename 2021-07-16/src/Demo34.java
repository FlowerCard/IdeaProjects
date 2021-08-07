import java.util.Scanner;

public class Demo34 {
    public static void main(String[] args) {
        //计算2/1+3/2+4/3+…+(n+1)/n，写出算法的程序
        double n = 0;
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入n：");
        n = scanner.nextDouble();
        for (double i=1 ; i<=n ; i++){
            result = result + (i+1)/i;
        }
        System.out.println("result：" + result);
    }
}
