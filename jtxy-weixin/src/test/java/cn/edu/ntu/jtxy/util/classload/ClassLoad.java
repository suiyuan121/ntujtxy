package cn.edu.ntu.jtxy.util.classload;

import org.junit.Test;

public class ClassLoad {

    @Test
    public void test_class_forname() throws ClassNotFoundException, InstantiationException,
                                    IllegalAccessException {

        Class class1 = Class.forName("cn.edu.ntu.jtxy.util.Test");
        //        class1.newInstance();
        System.out.println(" dsgsdg----" + class1.getName());
    }

    @Test
    public void test_classLoad() throws Exception {

        Class c = ClassLoad.class.getClassLoader().loadClass("cn.edu.ntu.jtxy.util.Test");

        System.out.println(" ----" + c.getName());
    }

}
