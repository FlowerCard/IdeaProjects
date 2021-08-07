package com.qf.test07;

public class Test07 {
    public static void main(String[] args) {
        NetUser netUser = new NetUser("HuaPai",123456);
        NetUser netUser1 = new NetUser("HuaPai",123456,"HuaPai@odcn.live");
        netUser.display();
        netUser1.display();
    }
}
