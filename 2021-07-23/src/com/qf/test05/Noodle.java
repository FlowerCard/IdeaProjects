package com.qf.test05;

public class Noodle {
    private String width;
    private int size;
    private boolean beef;
    private int eggs;

    public Noodle(){
        this.beef = false;
        this.size = 8;
        this.eggs = 0;
        this.width = "中宽";
    }

    public Noodle(String width,int size){
        this.width = width;
        this.size = size;
    }

    public Noodle(String width,int size,boolean beef){
        this.width = width;
        this.size = size;
        this.beef = beef;
    }

    public Noodle(String width,int size,boolean beef,int eggs){
        this.width = width;
        this.size = size;
        this.beef = beef;
        this.eggs = eggs;
    }

    public void showNoodleInfo(){
        int sum = 0;
        System.out.println("宽度：" + this.width);
        System.out.println("尺寸价格：" + this.size + "元");
        if (this.beef){
            System.out.println("加肉");
            sum = this.size + 4 + this.eggs;
        }else {
            System.out.println("不加肉");
            sum = this.size + this.eggs;
        }
        System.out.println("鸡蛋:" + this.eggs + "个");
        System.out.println("牛肉面的价格为：" + sum);
    }

}
