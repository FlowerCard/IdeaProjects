import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        //输入高度，输出倒直角三角形
        int height = 0;
        Scanner inputHeight = new Scanner(System.in);
        System.out.print("请输入高度：");
        height = inputHeight.nextInt();
        for (int i=0 ; i<height ; i++){
            for (int j=i ; j<height ; j++){
                System.out.print("#");
            }
            System.out.print("\n");
        }
    }
}
