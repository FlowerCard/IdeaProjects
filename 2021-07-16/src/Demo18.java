public class Demo18 {
    public static void main(String[] args) {
        //计算1000以内所有不能被7整除的整数之和
        int sum = 0;
        for (int i=0 ; i<1000; i++){
            if (i % 7 != 0){
                sum+=i;
            }
        }
        System.out.println("计算1000以内所有不能被7整除的整数之和为：" + sum);
    }
}
