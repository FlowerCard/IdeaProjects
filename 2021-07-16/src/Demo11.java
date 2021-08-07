public class Demo11 {
    public static void main(String[] args) {
       for (int i=0 ; i<7 ; i++){
           if (i<4){
               for (int j=0 ; j<2 * i + 1 ; j++){
                   System.out.print("*");
               }
               System.out.println();
           }else {
               for (int j = 0 ; j<13 - 2 * i ; j++){
                   System.out.print("*");
               }
               System.out.println();
           }
       }
    }
}
