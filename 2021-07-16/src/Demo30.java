public class Demo30 {
    public static void main(String[] args) {
        for (int i=0 ; i<9 ; i++){
            if (i<5){
                for (int k=4-i ; k>0 ; k--){
                    System.out.print(" ");
                }
                for (int j=0 ; j<2*i+1 ; j++){
                    System.out.print("*");
                }
                System.out.println();
            }else {
                for (int k=0 ; k<i-4 ; k++){
                    System.out.print(" ");
                }
                for (int j=17-2*i ; j>0 ; j--){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
