package cn.edu.ntu.jtxy.component;

import org.junit.Test;

import cn.edu.ntu.jtxy.BaseTest;
import cn.edu.ntu.jtxy.core.component.wx.PointComponent;
import cn.edu.ntu.jtxy.core.component.wx.result.PointOperateResult;
import cn.edu.ntu.jtxy.core.model.wx.PointDo.PointTypeEnum;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: RefreshTokenRepository.java, v 0.1 2016年3月23日 下午8:32:05 {jin.zhang@witontek.com} Exp $
 */
public class PointComponentImplTest extends BaseTest {

    @Test
    public void test_add() {
        PointComponent comp = getContext().getBean(PointComponent.class);

        PointOperateResult ret = comp.add("103040000000019", 20, PointTypeEnum.SIGN);
        logger.info("xxxxxxxxxxret={}", ret);
    }

    @Test
    public void test_use() {
        PointComponent comp = getContext().getBean(PointComponent.class);

        PointOperateResult ret = comp.add("103040000000017", 10, PointTypeEnum.SIGN);
        logger.info("xxxxxxxxxxret={}", ret);
    }
}
