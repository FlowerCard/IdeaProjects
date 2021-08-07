package com.qf.test07302.test06;

public class Test06 {
    public static void main(String[] args) {
        Door door = new RustProof();
        door.openDoor();
        door.closeDoor();
        if (door.rustproof()) {
            System.out.println("这个是防锈防火防弹防水防盗门");
        } else if (door.fireproof()) {
            System.out.println("这个是防火防弹防水防盗门");
        } else if (door.bulleproof()) {
            System.out.println("这个是防弹防水防盗门");
        } else if (door.waterproof()) {
            System.out.println("这个是防水防盗门");
        } else if (door.theftproof()) {
            System.out.println("这个是防盗门");
        }
    }
}
