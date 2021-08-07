public class Demo24 {
    public static void main(String[] args) {
        /*
        猴子吃桃问题： 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个，
        第二天早上又将剩下的桃子吃了一半，又多吃一个，以后每天都吃了前一天剩下的一半零一个。
        到第10天早上想再吃时，见只剩下一个桃子。求第一天共摘了多少个？
         */
        /*
        x * 2 + 1 == 每天吃掉的香蕉
        第十天的时候还剩一个
        前九天都是 x*2+1个
         */
        int banana = 1;
        for (int i=1 ; i<=10 ; i++){
            banana = banana * 2 +1;
        }
        System.out.println("第一天摘了" + banana + "根香蕉");
    }
}
