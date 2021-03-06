package cn.edu.ntu.jtxy.core.dao.mng.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.mng.NewsDao;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

public class NewsDaoImpl extends SqlSessionDaoSupport implements NewsDao {

    private static final Logger logger    = LoggerFactory.getLogger(DaliyQuestionDaoImpl.class);

    private static final String NAMESPACE = NewsDao.class.getName();

    @Override
    public PageList<String> pageQuery(int currentPage, int pageSize, String title, String type) {
        logger.info("分页查询新闻  currentPage={},pagesize={},title={},type={}", currentPage, pageSize,
            title, type);
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", title);
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

        List<String> list = getSqlSession().selectList(NAMESPACE + ".pageQuery", map);
        PageList<String> pageList = new PageList<String>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);
        return pageList;
    }

    @Override
    public List<NewsDo> getByMediaId(String mediaId) {
        logger.info("新闻 查询  mediaId={}", mediaId);
        return getSqlSession().selectList(NAMESPACE + ".getByMediaId", mediaId);
    }

    @Override
    public long add(NewsDo newsDo) {
        logger.info("新闻新增  newsDo={}", newsDo);
        getSqlSession().insert(NAMESPACE + ".add", newsDo);
        return newsDo.getId();
    }

    @Override
    public PageList<NewsDo> pageQueryAll(int currentPage, int pageSize, String title, String type) {
        logger.info("分页查询新闻  currentPage={},pagesize={},title={},type={}", currentPage, pageSize,
            title, type);
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", title);
        map.put("type", type);

        int totalCount = getSqlSession().selectOne(NAMESPACE + ".pageQueryAllCount", map);

        int pageNum = totalCount % pageSize > 0 ? (totalCount / pageSize) + 1
            : (totalCount / pageSize);

        if (currentPage > pageNum) {
            //当前页大于总页数，重置到首页
            currentPage = 1;
        }
        map.put("pageSize", String.valueOf(pageSize));
        map.put("offset", String.valueOf((currentPage - 1) * pageSize));

        List<NewsDo> list = getSqlSession().selectList(NAMESPACE + ".pageQueryAll", map);
        PageList<NewsDo> pageList = new PageList<NewsDo>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);
        return pageList;
    }

    @Override
    public boolean updateViewCountById(int id) {
        logger.info("增加浏览量  id={]", id);
        return getSqlSession().update(NAMESPACE + ".updateViewCountById", id) == 1;
    }
}
