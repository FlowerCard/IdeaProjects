public class Demo40 {
    public static void main(String[] args) {
        //用while做 求1000元钱可以买到38元的钢笔多少只
        int penCost = 0;
        int count = 1;
        while (penCost<1000){
            penCost = count * 38;
            count++;
        }
        System.out.println("1000元能买到" + (count-1) + "只钢笔");
    }
}
