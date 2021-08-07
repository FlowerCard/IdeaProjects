package com.qf.test07302.test03;

public abstract class Geometry {

    /**
     * 点    point
     * 线    line
     * 高    height
     * 宽    wide
     * 对角线  diagonal
     */
    protected double point;
    protected double line;
    protected double height;
    protected double wide;
    protected double diagonal;

    /**
     * 绘画方式
     */
    public abstract void draw();

    /**
     * 计算面积
     * @return  返回计算结果
     */
    public abstract double findArea();

    /**
     * 计算体积
     * @return  返回计算结果
     */
    public abstract double findVolume();

    /**
     * 计算周长
     * @return  返回周长计算结果
     */
    public abstract double findPerimeter();

    public Geometry() {
    }

    public Geometry(double point, double line, double height, double wide, double diagonal) {
        this.point = point;
        this.line = line;
        this.height = height;
        this.wide = wide;
        this.diagonal = diagonal;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public double getLine() {
        return line;
    }

    public void setLine(double line) {
        this.line = line;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "point=" + point +
                ", line=" + line +
                ", height=" + height +
                ", wide=" + wide +
                ", diagonal=" + diagonal +
                '}';
    }
}
