public class Demo32 {
    public static void main(String[] args) {
        //求300-400之间的素数
        for (int i=300 ; i<=400 ; i++){
            boolean suShu = true;
            for (int j=2 ; j<i ; j++){
                if (i % j == 0){
                    suShu = false;
                    break;
                }
            }
            if (suShu){
                System.out.println("素数：" + i);
            }
        }
    }
}
