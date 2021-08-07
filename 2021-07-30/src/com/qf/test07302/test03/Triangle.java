package com.qf.test07302.test03;

/**
 * 三角形
 * @author HuaPai@odcn.live
 *
 */
public class Triangle extends Geometry{
    /**
     * 绘画方式
     */
    @Override
    public void draw() {
        System.out.println("三角形怎么画的");
    }

    /**
     * 计算面积
     *
     * @return 返回计算结果
     */
    @Override
    public double findArea() {
        return 0;
    }

    /**
     * 计算体积
     *
     * @return 返回计算结果
     */
    @Override
    public double findVolume() {
        return 0;
    }

    /**
     * 计算周长
     *
     * @return 返回周长计算结果
     */
    @Override
    public double findPerimeter() {
        return 0;
    }
}
