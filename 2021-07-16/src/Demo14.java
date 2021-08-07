public class Demo14 {
    public static void main(String[] args) {
        //水仙花数
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        for (int i=100; i< 1000 ; i++){
            num1 = i/100;//百位
            num2 = i/10%10;//十位
            num3 = i%10;//个位
            if (i == Math.pow(num1,3) + Math.pow(num2,3) + Math.pow(num3,3)){
                System.out.println("水仙花数为：" + i);
            }
        }
    }
}
