public class Demo41 {
    public static void main(String[] args) {
        //用while做 鸡兔同笼。鸡兔一共有50只，脚一共有160只，问鸡和兔各多少只?要求鸡兔至少一样一只
        int i=1;
        while (i<=50){
            int j=1;
            while (j<=50){
                if (i*2 + j*4 == 160 && i+j==50){
                    System.out.println("鸡" + i + "\t兔子" + j);
                }
                j++;
            }
            i++;
        }
    }
}
