package com.qf.test07222.test01;

public class Box {
    int length;
    int wide;
    int height;

    /**
     * 表面积
     * @param length 输入长度
     * @param wide   输入宽度
     * @return       返回表面积
     */
    public int surfaceArea(int length,int wide){
        return (length * wide + length * wide + length * wide) * 2;
    }

    /**
     * 体积
     * @param length    输入长度
     * @param wide      输入宽度
     * @param height    输入高度
     * @return          返回体积
     */
    public int volume(int length,int wide,int height){
        return length * wide * height;
    }

}
