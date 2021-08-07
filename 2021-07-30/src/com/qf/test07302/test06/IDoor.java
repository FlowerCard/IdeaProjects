package com.qf.test07302.test06;

/**
 *  门功能接口
 * @author HuaPai@odcn.live
 */
public interface IDoor {

    /**
     * 防盗功能
     * @return  返回是否防盗
     */
    public abstract boolean theftproof();

    /**
     * 防水功能
     * @return  放回是否防水
     */
    public abstract boolean waterproof();

    /**
     * 防弹功能
     * @return  返回是否防弹
     */
    public abstract boolean bulleproof();

    /**
     * 防火功能
     * @return  返回是否防火
     */
    public abstract boolean fireproof();

    /**
     * 防锈功能
     * @return  返回是否防锈
     */
    public abstract boolean rustproof();

}
