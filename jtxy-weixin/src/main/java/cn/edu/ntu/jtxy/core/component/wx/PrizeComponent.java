package cn.edu.ntu.jtxy.core.component.wx;

import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;

public interface PrizeComponent {

    /**
     * 
     * @param priceRecordDo
     * @return
     */
    public BaseResult addPrice(PriceRecordDo priceRecordDo);

}
