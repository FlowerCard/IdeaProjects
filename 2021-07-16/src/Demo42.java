public class Demo42 {
    public static void main(String[] args) {
        //用while和while的嵌套，做 输出一个直角三角形的图案
        int i=1;
        int j=1;
        while (i<9){
            j=1;
            while (j<i){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
