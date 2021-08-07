public class Demo31 {
    public static void main(String[] args) {
        //打印出一个空菱形图案
        for (int i=1 ; i<=5 ; i++){
            for (int k=4 ; k>=i ; k--){
                System.out.print(" ");
            }
            for (int j=1 ; j<=i ; j++){
                if (j==1 || j==i){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i=4 ; i>=1 ; i--){
            for (int k=1 ; k<=5-i ; k++){
                System.out.print(" ");
            }
            for (int j=1 ; j<=i ; j++){
                if (j==1 || j==i){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
