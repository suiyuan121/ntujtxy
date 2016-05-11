package cn.edu.ntu.jtxy.core.repository.mng.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.mng.DaliyQuestionDao;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo.StatusEnum;
import cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.DaliyQuestionPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionRepositoryImpl.java, v 0.1 2016年5月5日 下午3:17:00 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionRepositoryImpl implements DaliyQuestionRepository {

    private static final Logger logger = LoggerFactory.getLogger(DaliyQuestionRepositoryImpl.class);

    @Autowired
    private DaliyQuestionDao    daliyQuestionDao;

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository#add(cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo)
     */
    @Override
    public long add(DailyQuestionDo dailyQuestionDo) {
        logger.info("每日一题新增  dailyQuestionDo={} ", dailyQuestionDo);
        if (dailyQuestionDo == null) {
            return -1;
        }
        return daliyQuestionDao.add(dailyQuestionDo);
    }

    @Override
    public PageList<DailyQuestionDo> pageQuery(DaliyQuestionPageQueryCond cond) {
        logger.info("每日一题信息分页查询  cond={}", cond);
        if (cond == null) {
            return null;
        }
        if (DailyQuestionDo.StatusEnum.getByCode(cond.getStatus()) == null) {
            cond.setStatus(DailyQuestionDo.StatusEnum.ENABLE.getCode());
        }
        if (DailyQuestionDo.TypeEnum.getByCode(cond.getType()) == null) {
            cond.setStatus(DailyQuestionDo.TypeEnum.COMMON.getCode());
        }
        return daliyQuestionDao.pageQuery(cond.getPageSize(), cond.getCurrentPage(),
            cond.getContent(), cond.getStatus(), cond.getValue(), cond.getType());
    }

    @Override
    public DailyQuestionDo getById(long id) {
        logger.info("每日一题信息查询  id={}", id);
        return daliyQuestionDao.getById(id);
    }

    @Override
    public boolean update(DailyQuestionDo dailyQuestionDo) {
        logger.info("每日一题信息更新 dailyQuestionDo={}", dailyQuestionDo);
        if (dailyQuestionDo == null) {
            return false;
        }
        return daliyQuestionDao.update(dailyQuestionDo);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository#getLast()
     */
    @Override
    public DailyQuestionDo getLast() {
        logger.info("获取每日一题信息");
        return daliyQuestionDao.getLast();
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.mng.DaliyQuestionRepository#updateLastStatus(cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo.StatusEnum)
     */
    @Override
    public boolean updateLastStatus(StatusEnum status) {
        logger.info("每日一题 最后一条置为失效   status={}", status);
        if (status == null) {
            return false;
        }
        return daliyQuestionDao.updateLastStatus(status.getCode());
    }
}
