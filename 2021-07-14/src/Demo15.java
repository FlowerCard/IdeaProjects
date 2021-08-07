public class Demo15 {
    public static void main(String[] args) {
        /*
        定义一个圆的半径，求圆的周长，圆的面积，圆球表面积，圆球的体积。输出结果时要求有文字说明，保留2位小数。
        提示:设圆的半径为R
            则周长 =2*PI*R
            面积 PI*r*r
            圆球表面积 4*PI*r*r
            圆球体积： 4/3*PI*r*r*r
         */
        int r2 = 10;
        double circleC = Math.round((2 * Math.PI * r2)*100)/100.0;
        double circleS1 = Math.round((Math.PI * r2 * r2)*100)/100.0;
        double circleSurfaceArea = Math.round((4 * Math.PI * r2 * r2) * 100)/100.0;
        double circleV1 = Math.round(((3 * Math.PI * r2 * r2 * r2)/4)*100)/100.0;
        System.out.println("圆的周长：" + circleC + "\t圆的面积：" +  circleS1 +
                "\t圆的表面积：" + circleSurfaceArea + "\t圆的体积：" + circleV1);
    }
}
