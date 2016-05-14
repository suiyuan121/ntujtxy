package cn.edu.ntu.jtxy.core.repository.wx;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.repository.wx.cond.PriceRecordPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PriceRecordRepository.java, v 0.1 2016年5月13日 上午9:07:32 zhangjinntu@163.com Exp $
 */
public interface PriceRecordRepository {

    /**
     * 
     * @param priceRecordDo
     * @return
     */
    public long add(PriceRecordDo priceRecordDo);

    /**
     * 
     * @param uid
     * @return
     */
    public List<PriceRecordDo> getByUid(String uid);

    /**
     * 
     * @param cond
     * @return
     */
    public PageList<PriceRecordDo> pageQuery(PriceRecordPageQueryCond cond);
}
