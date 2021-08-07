import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        //输入长和宽，输出长方形
        int length = 0;
        int weight = 0;
        Scanner inputNum = new Scanner(System.in);
        System.out.print("请输入长：");
        length = inputNum.nextInt();
        System.out.print("请输入宽：");
        weight = inputNum.nextInt();
        for (int i=0 ; i<weight ; i++){
            System.out.print("#");

            for (int j=0 ; j<length ; j++){
                System.out.print("#");
                if (j==length-1) System.out.print("\n");
            }
        }
    }
}
