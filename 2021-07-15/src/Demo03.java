import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        /*
        打印某年某月有多少天。
        （提示：A、闰年的计算方法：年数能被4整除，并且不能被100整除；或者能被400整除的整数年份。B、利用%运算可以判断一个数能否被另一个数整除。C、用CASE语句）
         */
        int inputYear;
        int inputMonth;
        Scanner inputDate = new Scanner(System.in);
        System.out.print("请输入年份：");
        inputYear = inputDate.nextInt();
        System.out.print("请输入月份：");
        inputMonth = inputDate.nextInt();
        //1,3,5,7,8,10,12-31天
        //4,6,9,11-30天
        //闰2-29天，平2-28天
        switch (inputMonth){
            case 2:
                if (inputYear % 4 ==0 && inputYear % 100 != 0 || inputYear % 400 == 0){
                    System.out.print("该月有29天");
                }else {
                    System.out.print("该月有28天");
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("该月有31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("该月有30天");
                break;
        }
    }
}
