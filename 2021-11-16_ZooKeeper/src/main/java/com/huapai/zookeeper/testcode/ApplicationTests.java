package com.huapai.zookeeper.testcode;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
class ApplicationTests {
    
    @Autowired
    CuratorFramework curatorFramework;

    /**
     * 创建节点
     * @throws Exception
     */
//    @Test
    void createNode() throws Exception {
        // 添加持久节点
        String path = curatorFramework.create().forPath("/curator-node");
        
        // 添加临时序号节点
        String path1 = curatorFramework.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/curator-node",
                "some data".getBytes());

        System.out.println(String.format("curator create node :%s successfully", path));
        
        System.out.println(String.format("curator create node :%s successfully", path1));
        
        System.in.read();
    }

    /**
     * 获得节点数据
     * @throws Exception
     */
//    @Test
    void testGetData() throws Exception {
        byte[] forPath = curatorFramework.getData().forPath("/curator-node");
        System.out.println(new String(forPath));
    }

    /**
     * 修改节点数据
     */
//    @Test
    void testSetData() throws Exception {
        curatorFramework.setData().forPath("/curator-node", "Data-Change!".getBytes());
        byte[] forPath = curatorFramework.getData().forPath("/curator-node");
        System.out.println(new String(forPath));
    }

    /**
     * 创建节点的同时，创建父节点
     * @throws Exception
     */
//    @Test
    void testCreateWithParent() throws Exception {
        String pathWithParent = "/node-parent/sub-node-1";
        String path = curatorFramework.create().creatingParentsIfNeeded().forPath(pathWithParent);
        System.out.println(String.format("curator create node :%s successfully", path));
    }

    /**
     * 删除节点
     */
//    @Test
    void testDelete() throws Exception {
        String pathWithParent = "/node-parent";
        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath(pathWithParent);
    }

//    @Test
    void contextLoads() {
    }

}
