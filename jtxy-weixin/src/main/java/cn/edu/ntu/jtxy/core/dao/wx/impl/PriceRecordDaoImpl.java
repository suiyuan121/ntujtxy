package cn.edu.ntu.jtxy.core.dao.wx.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.wx.PriceRecordDao;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.repository.wx.model.PrizeInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PriceRecordDaoImpl.java, v 0.1 2016年5月13日 上午8:54:45 zhangjinntu@163.com Exp $
 */
public class PriceRecordDaoImpl extends SqlSessionDaoSupport implements PriceRecordDao {

    private static final Logger logger    = LoggerFactory.getLogger(PriceRecordDaoImpl.class);

    private static final String NAMESPACE = PriceRecordDao.class.getName();

    @Override
    public long add(PriceRecordDo priceRecordDo) {
        logger.info("中奖纪录新增   priceRecordDo={}", priceRecordDo);
        return getSqlSession().insert(NAMESPACE + ".add", priceRecordDo);
    }

    @Override
    public List<PriceRecordDo> getByUid(String uid) {
        logger.info("中奖纪录查询  uid={}", uid);
        return getSqlSession().selectList(NAMESPACE + ".getByUid", uid);
    }

    @Override
    public PageList<PriceRecordDo> pageQuery(int pageSize, int currentPage, String uid) {
        logger.info("中奖纪录分页查询  pageSize={}，pageNum={},uid={}", pageSize, currentPage, uid);
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", uid);

        int totalCount = getSqlSession().selectOne(NAMESPACE + ".pageQueryCount", map);

        int pageNum = totalCount % pageSize > 0 ? (totalCount / pageSize) + 1
            : (totalCount / pageSize);

        if (currentPage > pageNum) {
            //当前页大于总页数，重置到首页
            currentPage = 1;
        }
        map.put("pageSize", String.valueOf(pageSize));
        map.put("offset", String.valueOf((currentPage - 1) * pageSize));

        List<PriceRecordDo> list = getSqlSession().selectList(NAMESPACE + ".pageQuery", map);
        PageList<PriceRecordDo> pageList = new PageList<PriceRecordDo>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);

        return pageList;
    }

    @Override
    public PageList<PrizeInfo> pageQuery(int pageSize, int currentPage, String stuName,
                                         String stuNo, String type) {
        logger.info("中奖纪录分页查询  pageSize={},currentPage={},stuName={},stuNo={},type={}", pageSize,
            currentPage, stuName, stuNo, type);

        Map<String, String> map = new HashMap<String, String>();
        map.put("stuName", stuName);
        map.put("stuNo", stuNo);
        map.put("type", type);

        int totalCount = getSqlSession().selectOne(NAMESPACE + ".pageQueryInfoCount", map);

        int pageNum = totalCount % pageSize > 0 ? (totalCount / pageSize) + 1
            : (totalCount / pageSize);

        if (currentPage > pageNum) {
            //当前页大于总页数，重置到首页
            currentPage = 1;
        }
        map.put("pageSize", String.valueOf(pageSize));
        map.put("offset", String.valueOf((currentPage - 1) * pageSize));

        List<PrizeInfo> list = getSqlSession().selectList(NAMESPACE + ".pageQueryInfo", map);
        PageList<PrizeInfo> pageList = new PageList<PrizeInfo>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);

        return pageList;

    }

}
