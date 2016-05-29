package cn.edu.ntu.jtxy.util;

import java.io.File;

public class Test {

    public static void main(String[] args) {

        System.out.println("main do ...");
    }

    static {
        System.out.println("static  do ...");
    }

    public Test() {
        System.out.println("构造函数。。。。");
        File f = new File("");
        f.listFiles();
        f.isDirectory();
    }
}
