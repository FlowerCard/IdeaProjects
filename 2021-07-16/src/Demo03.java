public class Demo03 {
    public static void main(String[] args) {
        //输出从 1 到 100 之间所有不能被3整除的数；并输出这些整数的和
        int sum = 0;
        for (int i=1 ; i<=100 ; i++){
            if (i % 3 != 0){
                System.out.println(i);
                sum+=i;
            }
        }
        System.out.println("这些数的和为：" + sum);
    }
}
