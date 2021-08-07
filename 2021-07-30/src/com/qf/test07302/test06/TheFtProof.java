package com.qf.test07302.test06;

/**
 * 防盗门
 * @author HuaPai@odcn.live
 */
public abstract class TheFtProof extends Door{
    /**
     * 开门
     */
    @Override
    public void openDoor() {
        System.out.println("防盗门开门");
    }

    /**
     * 关门
     */
    @Override
    public void closeDoor() {
        System.out.println("防盗门开门");
    }

    /**
     * 防盗功能
     *
     * @return 返回是否防盗
     */
    @Override
    public boolean theftproof() {
        return true;
    }
}
