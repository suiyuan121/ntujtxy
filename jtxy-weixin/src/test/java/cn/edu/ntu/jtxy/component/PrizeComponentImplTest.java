package cn.edu.ntu.jtxy.component;

import org.junit.Test;

import cn.edu.ntu.jtxy.BaseTest;
import cn.edu.ntu.jtxy.core.component.wx.PrizeComponent;
import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo.PriceTypeEnum;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: RefreshTokenRepository.java, v 0.1 2016年3月23日 下午8:32:05 {jin.zhang@witontek.com} Exp $
 */
public class PrizeComponentImplTest extends BaseTest {

    @Test
    public void test_add() {
        PrizeComponent comp = getContext().getBean(PrizeComponent.class);

        PriceRecordDo priceRecordDo = new PriceRecordDo();
        priceRecordDo.setUid("103040000000017");
        priceRecordDo.setPriceLevel(PriceTypeEnum.一等奖.getCode());

        BaseResult ret = comp.addPrice(priceRecordDo);
        logger.info("xxxxxxxxxxret={}", ret);
    }
}
