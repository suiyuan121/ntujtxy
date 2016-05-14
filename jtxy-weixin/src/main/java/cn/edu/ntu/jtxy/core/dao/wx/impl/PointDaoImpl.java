package cn.edu.ntu.jtxy.core.dao.wx.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.wx.PointDao;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;
import cn.edu.ntu.jtxy.core.repository.wx.model.PointInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: RefreshTokenDaoImpl.java, v 0.1 2016年3月22日 下午2:00:12 {jin.zhang@witontek.com} Exp $
 */
public class PointDaoImpl extends SqlSessionDaoSupport implements PointDao {

    private static final Logger logger    = LoggerFactory.getLogger(PointDaoImpl.class);

    private static final String NAMESPACE = PointDao.class.getName();

    @Override
    public long add(PointDo pointDo) {
        logger.info("积分新增  pointDo={}", pointDo);
        getSqlSession().insert(NAMESPACE + ".add", pointDo);
        return pointDo.getId();
    }

    @Override
    public PointDo lockById(long id) {
        logger.info("加锁    id={}", id);
        return getSqlSession().selectOne(NAMESPACE + ".lockById", id);
    }

    @Override
    public boolean update(PointDo pointInfo) {
        logger.info("更新    pointInfo={}", pointInfo);
        return getSqlSession().update(NAMESPACE + ".update", pointInfo) == 1;
    }

    @Override
    public PointDo getByUidAndType(String uid, String type) {
        logger.info("积分查询   uid={},poinType={}", uid, type);
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", uid);
        map.put("type", type);
        return getSqlSession().selectOne(NAMESPACE + ".getByUidAndType", map);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.dao.wx.PointDao#pageQuery(int, int, java.lang.String, java.lang.String)
     */
    @Override
    public PageList<PointInfo> pageQuery(int pageSize, int currentPage, String stuNo, String stuName) {
        logger.info("积分 分页查询  pageSize={},pageCurrent={},stuNo={},stuName={}", pageSize,
            currentPage, stuNo, stuName);
        Map<String, String> map = new HashMap<String, String>();
        map.put("stuNo", stuNo);
        map.put("stuName", stuName);

        int totalCount = getSqlSession().selectOne(NAMESPACE + ".pageQueryCount", map);

        int pageNum = totalCount % pageSize > 0 ? (totalCount / pageSize) + 1
            : (totalCount / pageSize);

        if (currentPage > pageNum) {
            //当前页大于总页数，重置到首页
            currentPage = 1;
        }
        map.put("pageSize", String.valueOf(pageSize));
        map.put("offset", String.valueOf((currentPage - 1) * pageSize));

        List<PointInfo> list = getSqlSession().selectList(NAMESPACE + ".pageQuery", map);
        PageList<PointInfo> pageList = new PageList<PointInfo>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);

        return pageList;
    }

    @Override
    public int getTotalByUid(String uid) {
        logger.info("查询全部积分   uid={}", uid);
        return getSqlSession().selectOne(NAMESPACE + ".getTotalByUid", uid);
    }
}
