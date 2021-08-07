public class Demo09 {
    public static void main(String[] args) {
        //求长方形的周长和面积
        int longRectangle = 5;
        int widthRectangle = 3;
        int rectangleC = (longRectangle + widthRectangle) * 2;
        int rectangleS = longRectangle * widthRectangle;
        System.out.println("长方形周长：" + rectangleC + "，长方形面积：" + rectangleS);
    }
}
