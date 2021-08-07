package com.qf.test07302.test07;

/**
 * XXX纯净水生产线
 * @author HuaPai@odcn.live
 */
public class Test07 {
    public static void main(String[] args) {
        Water water01 = new Water01();
        Water water02 = new Water02();
        Water water03 = new Water03();
        Water water04 = new Water04();

        if (water01 instanceof Water01) {
            water01.getWater();
            ((Water01) water01).filter();
            ((Water01) water01).buffer();
        }

        if (water02 instanceof Water02) {
            water02.getWater();
            ((Water02) water02).buffer();
        }

        if (water03 instanceof Water03) {
            water03.getWater();
            ((Water03) water03).filter();
        }

        if (water04 instanceof Water04) {
            water04.getWater();
            ((Water04) water04).sugar();
        }

        System.out.println("花牌结束了他罪恶的一生");
    }
}
