import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入高度，输出直角三角形
        int heigth = 0;
        Scanner inputHeight = new Scanner(System.in);
        System.out.print("请输入高度：");
        heigth = inputHeight.nextInt();
        for (int i=0 ; i<heigth ; i++){
            for (int j=0 ; j<i+1 ; j++){
                System.out.print("#");
            }
            System.out.print("\n");
        }
    }
}
