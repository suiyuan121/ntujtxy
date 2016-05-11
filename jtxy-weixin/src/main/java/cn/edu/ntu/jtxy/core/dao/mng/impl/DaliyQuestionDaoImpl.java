package cn.edu.ntu.jtxy.core.dao.mng.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.mng.DaliyQuestionDao;
import cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: DaliyQuestionDaoImpl.java, v 0.1 2016年5月5日 下午3:14:43 zhangjinntu@163.com Exp $
 */
public class DaliyQuestionDaoImpl extends SqlSessionDaoSupport implements DaliyQuestionDao {

    private static final Logger logger    = LoggerFactory.getLogger(DaliyQuestionDaoImpl.class);

    private static final String NAMESPACE = DaliyQuestionDao.class.getName();

    /** 
     * @see cn.edu.ntu.jtxy.core.dao.mng.DaliyQuestionDao#add(cn.edu.ntu.jtxy.core.model.mng.DailyQuestionDo)
     */
    @Override
    public long add(DailyQuestionDo dailyQuestionDo) {
        logger.info("每日一题新增    dailyQuestionDo={}", dailyQuestionDo);
        getSqlSession().insert(NAMESPACE + ".insert", dailyQuestionDo);
        return dailyQuestionDo.getId();
    }

    @Override
    public PageList<DailyQuestionDo> pageQuery(int pageSize, int currentPage, String content,
                                               String status, int value, String type) {
        logger.info("每日一题查询全部学生  pageSize={},pageCurrent={},content={},status={},value={}",
            pageSize, currentPage, content, status, value);
        Map<String, String> map = new HashMap<String, String>();
        map.put("content", content);
        map.put("status", status);
        map.put("value", String.valueOf(value));
        map.put("type", type);

        int totalCount = getSqlSession().selectOne(NAMESPACE + ".pageQueryCount", map);

        int pageNum = totalCount % pageSize > 0 ? (totalCount / pageSize) + 1
            : (totalCount / pageSize);

        if (currentPage > pageNum) {
            //当前页大于总页数，重置到首页
            currentPage = 1;
        }
        map.put("pageSize", String.valueOf(pageSize));
        map.put("offset", String.valueOf((currentPage - 1) * pageSize));

        List<DailyQuestionDo> list = getSqlSession().selectList(NAMESPACE + ".pageQuery", map);
        PageList<DailyQuestionDo> pageList = new PageList<DailyQuestionDo>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);

        return pageList;
    }

    @Override
    public DailyQuestionDo getById(long id) {
        logger.info("每日一题信息查询  id={}", id);
        return getSqlSession().selectOne(NAMESPACE + ".getById", id);
    }

    @Override
    public boolean update(DailyQuestionDo dailyQuestionDo) {
        logger.info("每日一题信息更新  dailyQuestionDo={}", dailyQuestionDo);
        return getSqlSession().update(NAMESPACE + ".update", dailyQuestionDo) == 1;
    }

    @Override
    public DailyQuestionDo getLast() {
        logger.info("获取每日一题信息(最先的一条可用的)");
        return getSqlSession().selectOne(NAMESPACE + ".getLast");
    }

    @Override
    public boolean updateLastStatus(String status) {
        logger.info("每日一题置为失效   status={}", status);
        return getSqlSession().update(NAMESPACE + ".updateLastStatus", status) == 1;
    }
}
