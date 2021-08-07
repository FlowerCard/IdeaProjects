public class Demo10 {
    public static void main(String[] args) {
        //3000米长的绳子，每天减少一半。问多少天这个绳子会小于5m
        int day = 0;
        //方法一
        for (int i=3000 ; i>=5 ; i/=2){
            day++;
        }
        System.out.println(day+"天后小于5m");

//        方法二
//        for (int i=3000 ; i>=5 ; day++){
//            i = i / 2;
//        }
//        System.out.println(day+"天后小于5m");
    }
}
