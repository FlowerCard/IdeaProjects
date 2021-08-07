public class Demo12 {
    public static void main(String[] args) {
        for (int i=0 ; i<5 ; i++){
            for (int j=0 ; j<4-i ; j++){
                System.out.print(" ");
            }
            for (int x=0 ; x<i+1 ; x++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i=0 ; i<4 ; i++){
            for (int j=0 ; j<i+1 ; j++){
                System.out.print(" ");
            }
            for (int x=0 ; x<4-i ; x++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
