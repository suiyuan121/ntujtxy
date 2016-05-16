package cn.edu.ntu.jtxy.core.repository.wx.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.wx.PriceRecordDao;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.repository.wx.PriceRecordRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.PriceRecordPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.cond.PrizePageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.model.PrizeInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PriceRecordRepositoryImpl.java, v 0.1 2016年5月13日 上午9:10:14 zhangjinntu@163.com Exp $
 */
public class PriceRecordRepositoryImpl implements PriceRecordRepository {

    private static final Logger logger = LoggerFactory.getLogger(PriceRecordRepositoryImpl.class);

    @Autowired
    private PriceRecordDao      priceRecordDao;

    @Override
    public synchronized long add(PriceRecordDo priceRecordDo) {
        logger.info("中奖纪录新增   priceRecordDo={}", priceRecordDo);
        if (priceRecordDo == null) {
            return -1;
        }
        return priceRecordDao.add(priceRecordDo);
    }

    @Override
    public List<PriceRecordDo> getByUid(String uid) {
        logger.info("中奖纪录查询   uid={}", uid);
        if (StringUtils.isBlank(uid)) {
            return null;
        }
        return priceRecordDao.getByUid(uid);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.PriceRecordRepository#pageQuery(cn.edu.ntu.jtxy.core.repository.wx.pagelist.cond.StuInfoPageCond)
     */
    @Override
    public PageList<PriceRecordDo> pageQuery(PriceRecordPageQueryCond cond) {
        logger.info("中奖纪录分页查询   cond={}", cond);
        if (cond == null) {
            return null;
        }
        return priceRecordDao.pageQuery(cond.getPageSize(), cond.getCurrentPage(), cond.getUid());
    }

    @Override
    public PageList<PrizeInfo> pageQuery(PrizePageQueryCond cond) {
        logger.info("奖品纪录分页");
        
        return null;
    }
}
