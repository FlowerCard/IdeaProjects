package com.qf.test03;

public class WuMingFen {
    private String theMa;
    private int x;
    private boolean likeSoup;

    public WuMingFen(){
        this.theMa = "酸辣面";
        this.x = 2;
        this.likeSoup = true;
    }

    public WuMingFen(String theMa,int x){
        this.theMa = theMa;
        this.x = x;
    }

    public WuMingFen(String theMa,int x,boolean likeSoup){
        this.theMa = theMa;
        this.x = x;
        this.likeSoup = likeSoup;
    }

    public void check(){
        System.out.println(theMa + "," + x + "," + likeSoup);
    }

}
