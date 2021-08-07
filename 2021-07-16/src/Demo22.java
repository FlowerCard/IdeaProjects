import java.util.Scanner;

public class Demo22 {
    public static void main(String[] args) {
        //定义一个正整数如：1205  统计它的各位数字中零的个数，并求各位数字中的最大者
        int num = 1000;
        int n1 = num / 1000;
        int n2 = num / 100 % 10;
        int n3 = num / 10 % 10;
        int n4 = num % 10;
        int[] ns = {n1,n2,n3,n4};
        int count = 0;
        for (int i=0 ; i<ns.length ; i++){
            if (ns[i] == 0){
                count++;
            }
        }
        System.out.println("零的个数为：" + count);
        int max = Math.max(Math.max(Math.max(n1,n2),n3),n4);
        System.out.println("最大者为：" + max);
    }
}
