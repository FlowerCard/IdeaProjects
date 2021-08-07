public class Demo38 {
    public static void main(String[] args) {
        /*
        水仙花数（Narcissistic number）也被称为超完全数字不变数、自恋数、自幂数，
        水仙花数是指一个 n 位数（n≥3 ），它的每个位上的数字的 n 次幂之和等于它本身
        （例如：1^3 + 5^3+ 3^3 = 153）,请通过程序找出所有的3位数的水仙花数（穷举法）
         */
        int hundred = 0;
        int ten = 0;
        int bits = 0;
        for (int i=100 ; i<=999 ; i++){
            hundred = i / 100;
            ten = i / 10 % 10;
            bits = i % 10;
            if (Math.pow(hundred,3) + Math.pow(ten,3) + Math.pow(bits,3) == i){
                System.out.println("该水仙花数为：" + i);
            }
        }
    }
}
