package cn.edu.ntu.jtxy.util;

import org.junit.Test;

public class Equeals {

    @Test
    public void test() {

        String s = "hello";

        String s2 = new String("hello");

        System.out.println(s == s2);
    }
}
