public class Demo43 {
    public static void main(String[] args) {
        //用while和while的嵌套，做 输出九九乘法表
        int i=1;
        while (i<=9){
            int j=1;
            while (j<=i){

                int multi = j*i;
                System.out.print(i + "*" + j + "=" + multi + "\t");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
