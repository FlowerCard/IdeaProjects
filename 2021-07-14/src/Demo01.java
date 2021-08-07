public class Demo01 {
    public static void main(String[] args){
        int n = 5;
        int m = 13;
        int temp = 0;
        temp = n;
        n = m;
        m = temp;
        System.out.println("n=" + n + ",m=" + m);
    }
}
