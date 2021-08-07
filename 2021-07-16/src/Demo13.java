public class Demo13 {
    public static void main(String[] args) {
        /*
        一个数如果恰好等于它的因子之和，这个数就称为"完数"。（因子：除去这个数本身正的约数）
        例如6=1＋2＋3.编程 找出1000以内的所有完数
         */
        int count = 0;
        int num = 0;
        for (int i=1 ; i<=1000 ; i++){
            for (int j=1 ; j<i ; j++){
                if (i%j==0){
                    //因子之和
                    num+=j;
                }
                if (num == i){
                    //统计完数的个数
                    count++;
                }
            }
            //初始化
            num = 0;
        }
        System.out.println("完数的个数为：" + count);
    }
}
