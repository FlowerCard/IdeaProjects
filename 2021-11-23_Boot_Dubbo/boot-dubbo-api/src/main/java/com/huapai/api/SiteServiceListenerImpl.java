package com.huapai.api;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
public class SiteServiceListenerImpl implements SiteServiceListener, Serializable {
    @Override
    public void changed(String data) {
        System.out.println("changed: " + data);
    }
}
