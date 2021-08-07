public class Demo19 {
    public static void main(String[] args){
        /*
        设  boolean   m; int    a=1,b=3,c=9;则计算
          m=(a>b)&&(b<c);
          m=  ((a>=b)&&(b==c)||(c<a))
         */
        boolean m;
        int a = 1;
        int b = 3;
        int c = 9;
        m = (a>b) && (b<c);
        System.out.println(m);
        m = ((a>=b) && (b==c) || (c<a));
        System.out.println(m);
    }
}
