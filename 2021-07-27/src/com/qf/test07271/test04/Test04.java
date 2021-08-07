package com.qf.test07271.test04;

public class Test04 {
    public static void main(String[] args) {
        Officials officials = new Officials();
        officials.id = "430224199001010020";
        officials.name = "张三";
        officials.birthday = "1990-01-01";
        officials.educational = "浙大能源博士";
        officials.professional = "研究员";
        officials.party = "中国共产党";
        officials.position = "副市长";

        System.out.println(officials.id + "," + officials.name + "," + officials.birthday + "," + officials.educational
        + "," +  officials.professional + "," + officials.party + "," + officials.position);

    }
}
