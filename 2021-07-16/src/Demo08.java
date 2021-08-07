public class Demo08 {
    public static void main(String[] args) {
        //输入两个正整数 m 和 n，求其最大公约数和最小公倍数
        int m = 12;
        int n = 28;
        //获取 m 和 n 的较大值
        int max = Math.max(m,n);
        //获取 m 和 n 的较小值
        int min = Math.min(m,n);
        //求 m 和 n 的最大公约数
        for (int i=min ; i>=1 ; i--){
            if (m % i == 0 && n % i == 0){
                System.out.println("m 和 n 的最大公约数是：" + i);
                break;
            }
        }
        //求 m 和 n 的最小公倍数
        for (int i=max ; i<m*n ; i++){
            if (i % m == 0 && i % n == 0){
                System.out.println("m 和 n 的最小公倍数是：" + i);
                break;
            }
        }
    }
}
