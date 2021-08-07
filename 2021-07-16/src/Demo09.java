public class Demo09 {
    public static void main(String[] args) {
        //打印 1~100 之间 6 的倍数的个数
        int count = 0;
        for (int i=1 ; i<=100 ; i++){
            if (i % 6 ==0){
                count++;
            }
        }
        System.out.println("6的倍数个数为：" + count + "个");
    }
}
