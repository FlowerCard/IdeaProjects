public class Demo37 {
    public static void main(String[] args) {
        /*
        有个人想知道，一年之内一对兔子能繁殖多少对？于是就筑了一道围墙把一对兔子关在里面。
        已知一对兔子每个月可以生一对小兔子，而一对兔子从出生后第3个月起每月生一对小兔子。
        假如一年内没有发生死亡现象，那么，一对兔子一年内（12个月）能繁殖成多少对？
        分析：兔子的规律为数列，1，1，2，3，5，8，13，21
        Fn+2 = fn+1 + fn;
         */
        int a = 1;
        int b = 1;
        int i = 2;
        while (i<12){
            i++;
            a+=b;
            if (i == 12) {
                System.out.println(a);
            }
            i++;
            b+=a;
            if (i == 12) {
                System.out.println(b);
            }
        }
    }
}
