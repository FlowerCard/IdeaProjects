public class Demo11 {
    public static void main(String[] args) {
        //定义三个数，求出其中的最大值
        int num1 = 100;
        int num2 = 2222;
        int num3 = 4000;
        int max = Math.max(Math.max(num1,num2),num3);
        System.out.println(max);
    }
}
