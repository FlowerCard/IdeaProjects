package com.qf.test07302.test06;

/**
 * 防水防盗门
 * @author HuaPai@odcn.live
 */
public abstract class WaterProof extends TheFtProof{
    /**
     * 防水功能
     *
     * @return 放回是否防水
     */
    @Override
    public boolean waterproof() {
        return true;
    }
}
