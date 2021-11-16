package com.huapai.zookeeper.testcode;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/16.
 */
@Slf4j
//@SpringBootTest
public class CuratorWatchTests {
    
    @Autowired
    private CuratorFramework curatorFramework;

    /**
     * Watch监听器
     */
//    @Test
    void addNodeListener() throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework, "/curator-node");
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                log.info("{} path nodeChanged: ", "/curator-node");
                printNodeData();
            }
        });
        nodeCache.start();
        System.in.read();
    }
    
    public void printNodeData() throws Exception {
        byte[] path = curatorFramework.getData().forPath("/curator-node");
        log.info("data: {}", new String(path));
    }
    
}
