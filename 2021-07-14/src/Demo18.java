public class Demo18 {
    public static void main(String[] args){
        //设 int  m=9,n; 分别计算n=++m   和  n=m++ 后 , m 和 n的结果是多少？
        int m = 9;
        int n;
        n = ++m;
        System.out.println(n);
        System.out.println(m);
        m=9;
        n = m++;
        System.out.println(n);
        System.out.println(m);
    }
}
