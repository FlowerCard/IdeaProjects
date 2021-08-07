public class Demo35 {
    public static void main(String[] args) {
        //2000年我国人口为13亿，如果人口每年的自然增长率为7%，那么多少年 后我国人口将达到15亿？设计一个算法的程序
        int year = 0;
        double population = 13;//单位亿
        while (population < 15){
            //每年增长7%，现有人口加上增长人口
            population = population + population * 0.07;
            year++;
        }
        System.out.println(year + "年后，人口到达15亿");
    }
}
