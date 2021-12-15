package com.huapai.door;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 */
public class Door {
    
    protected void openDoor() {
        System.out.println("开门");
    }
    
    public void closeDoor() {
        System.out.println("关门");
    }
    
    public void colour(String colorName) {
        System.out.println("这是一个" + colorName + "的门");
    }
    
}
