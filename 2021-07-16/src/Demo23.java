public class Demo23 {
    public static void main(String[] args) {
        //有1020个西瓜,第一天卖掉总数的一半后又多卖出两个,以后每天卖剩下的一半多两个,问几天以后能卖完
        int xg = 1020;
        int day = 0;
        for (int i = 1 ; i<=xg ; xg = xg/2-2){
            day++;
        }
        System.out.println("西瓜" + day + "天后卖完");
    }
}
