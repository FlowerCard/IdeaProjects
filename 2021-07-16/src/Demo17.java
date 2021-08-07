public class Demo17 {
    public static void main(String[] args) {
        //计算出1—100之间所有能被3整除的整数的和
        int sum = 0;
        for (int i=1 ; i<=100 ; i++){
            if (i % 3 ==0){
                sum+=i;
            }
        }
        System.out.println("1—100之间所有能被3整除的整数的和为：" + sum);
    }
}
