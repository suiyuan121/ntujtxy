package cn.edu.ntu.jtxy.util;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: StuNoUtil.java, v 0.1 2016年5月3日 下午5:00:19 zhangjinntu@163.com Exp $
 */
public class StuNoUtil {

    public static String getGrade(String stuNo) {
        return StringUtils.substring(stuNo, 0, 2);
    }

}
