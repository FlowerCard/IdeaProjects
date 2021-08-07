package com.qf.test04;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    /**
     * 初始化
     */
    public MyTime(){
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    /**
     * 加秒
     * @param sec 输入增加的秒数
     * @return  返回计算的秒数
     */
    public int addSecond(int sec){
        if (this.second + sec > 60){
            this.minute++;
            this.second = 0;
        }else{
            this.second+=sec;
        }
        return this.second;
    }

    /**
     * 加分钟
     * @param min 输入增加的分钟
     * @return  返回计算的分钟
     */
    public int addMinute(int min){
        if (this.minute + min > 60){
            this.hour++;
            this.minute = 1;
        }else{
            this.minute+=min;
        }
        return this.minute;
    }

    /**
     * 加小时
     * @param hou  输入增加的小时
     * @return  返回计算的小时
     */
    public int addHour(int hou){
        if (this.hour + hou > 24){
            this.hour = 1;
        }else {
            this.hour+=hou;
        }
        return this.hour;
    }

    /**
     * 减秒
     * @param sec 输入减少的秒数
     * @return 返回计算的秒数
     */
    public int subSecond(int sec){
        if (this.second - sec < 0 ){
            this.minute--;
            this.second = 0;
        }else {
            this.second-=sec;
        }
        return this.second;
    }

    /**
     * 减分钟
     * @param min 输入减少的分钟
     * @return  返回计算的分钟
     */
    public int subMinute(int min){
        if (this.minute - min < 0){
            this.hour--;
            this.minute = 0;
        }else {
            this.minute-=min;
        }
        return this.minute;
    }

    /**
     * 减小时
     * @param hou  输入减少的小时
     * @return  返回计算的小时
     */
    public int subHour(int hou){
        if (this.hour - hou < 0){
            this.hour = 0;
        }else {
            this.hour-=hou;
        }
        return this.hour;
    }

    public void display(){
        System.out.println(this.hour + "时" + this.minute + "分" + this.second + "秒");
    }

}
