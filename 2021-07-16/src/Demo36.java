public class Demo36 {
    public static void main(String[] args) {
        /*
        给出50个数，1，2，4，7，11，„，
        其规律是：第1个数是1，第2个数比第1个数大1，第3个数比第2个数大2，第4个数比第3个数大3，„，
        1:1+0,2:2+1,3:3+2:4:4+3
        以此类推. 要求计算这50个数的和. 先将下面给出的程序框图，再根据程序框图写出程序
         */
        int upNum = 0;
        int sum = 0;
        for (int i=1 ; i<=50 ; upNum++){
            i+=upNum;
            sum += i;
        }
        System.out.println(sum);
    }
}
