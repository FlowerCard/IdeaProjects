package com.qf.test08031.test05;

import java.util.Objects;

public class Poker implements Comparable<Poker>{
    private String color;
    private String point;
    private int n;//实际大小
    private int c;//花色大小

    public Poker() {
    }

    public Poker(String color, String point) {
        this.color = color;
        this.point = point;
    }

    public Poker(String color, String point, int n, int c) {
        this.color = color;
        this.point = point;
        this.n = n;
        this.c = c;
    }

    public Poker(String color, String point, int n) {
        this.color = color;
        this.point = point;
        this.n = n;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getN() {
        return n;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "color='" + color + '\'' +
                ", point='" + point + '\'' +
                '}';
    }

    @Override
    public int compareTo(Poker o) {
        int a = this.color.compareTo(o.color);
        if (a == 0) {
            return this.n - o.n;
        }
        return a;
    }
}
