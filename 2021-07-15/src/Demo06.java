import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        //定义一个字符，判断是否为字母
        char eng = 'k';
        /*
        a-z:97-122
        A-Z:65-90
         */
        System.out.println("定义的字符为：" + eng);
        if (eng >= 97 && eng <= 122){
            System.out.println("该字符为字母");
        }else if (eng >= 65 && eng <= 90){
            System.out.println("该字符为字母");
        }else {
            System.out.println("该字符不为字母");
        }
    }
}
