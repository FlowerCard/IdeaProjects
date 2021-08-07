public class Demo02 {
    public static void main(String[] args){
        int a = 60;
        String str1 = Integer.toBinaryString(a);
        String str2 = Integer.toHexString(a);
        System.out.println("0Ba=" + str1 + ",0Xa=" + str2);
    }
}
