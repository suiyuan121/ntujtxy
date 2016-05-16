package cn.edu.ntu.jtxy.core.repository.mng.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import cn.edu.ntu.jtxy.core.dao.mng.NewsDao;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.NewsPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

public class NewsRepositoryImpl implements NewsRepository {

    private static final Logger logger = LoggerFactory.getLogger(NewsRepositoryImpl.class);

    @Autowired
    private NewsDao             newsDao;

    @Override
    public PageList<String> pageQuery(NewsPageQueryCond cond) {
        logger.info("新闻分页查询    cond={}", cond);
        if (cond == null) {
            return null;
        }
        return newsDao.pageQuery(cond.getCurrentPage(), cond.getPageSize(), cond.getTitle(),
            cond.getType());
    }

    @Override
    public long add(NewsDo newsDo) {
        logger.info("新闻新增   newsDo={}", newsDo);
        if (newsDo == null) {
            return -1L;
        }
        try {
            return newsDao.add(newsDo);
        } catch (DuplicateKeyException e) {
            logger.error(String.format("新闻增加异常 -主键冲突  newsDo={}", newsDo), e);
        } catch (Exception e2) {
            logger.error(String.format("新闻增加异常   newsDo={}", newsDo), e2);
        }
        return -1;

    }

    @Override
    public List<NewsDo> getByMediaId(String mediaId) {
        logger.info("新闻查询   mediaId={}", mediaId);
        if (StringUtils.isEmpty(mediaId)) {
            return null;
        }
        return newsDao.getByMediaId(mediaId);
    }

    @Override
    public PageList<NewsDo> pageQueryAll(NewsPageQueryCond cond) {
        logger.info("新闻分页查询    cond={}", cond);
        if (cond == null) {
            return null;
        }
        return newsDao.pageQueryAll(cond.getCurrentPage(), cond.getPageSize(), cond.getTitle(),
            cond.getType());
    }

    @Override
    public boolean updateViewCountById(int id) {
        logger.info("浏览量增加    id={}", id);
        if (id <= 0) {
            return false;
        }
        return newsDao.updateViewCountById(id);
    }
}
