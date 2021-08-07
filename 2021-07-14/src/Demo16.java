public class Demo16 {
    public static void main(String[] args){
        /*
        定义三个数a=10,b=20,c=30 结果
        1  （（a>=b）==(b==c)==(c<a)）
        2 （a!=b）==(a!=c)==(c==a)
        3 !(a>b)
         */
        int a=10;
        int b=20;
        int c=30;
        boolean bol1 = (a>=b) == (b==c) == (c<a);
        boolean bol2 = (a!=b) == (a!=c) == (c==a);
        boolean bol3 = !(a>b);
        System.out.println(bol1 + "\t" + bol2 + "\t" + bol3);
    }
}
