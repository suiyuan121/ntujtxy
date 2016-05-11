package cn.edu.ntu.jtxy.core.dao.wx.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.ntu.jtxy.core.dao.wx.ImagesDao;
import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: RefreshTokenDaoImpl.java, v 0.1 2016年3月22日 下午2:00:12 {jin.zhang@witontek.com} Exp $
 */
public class ImagesDaoImpl extends SqlSessionDaoSupport implements ImagesDao {

    private static final Logger logger    = LoggerFactory.getLogger(ImagesDaoImpl.class);

    private static final String NAMESPACE = ImagesDao.class.getName();

    @Override
    public long add(ImagesDo imagesDo) {
        logger.info("图片增加  imagesDo={}", imagesDo);
        getSqlSession().insert(NAMESPACE + ".add", imagesDo);
        return imagesDo.getId();
    }

    @Override
    public PageList<ImagesDo> pageQuery(int pageSize, int currentPage, String type, String uid,
                                        String orderType) {
        logger.info("图片分页查询  pageSize={},currentPage={},type={}，uid={},orderType={}", pageSize,
            currentPage, type, uid, orderType);
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("uid", uid);
        map.put("orderType", orderType);

        int totalCount = getSqlSession().selectOne(NAMESPACE + ".pageQueryCount", map);

        int pageNum = totalCount % pageSize > 0 ? (totalCount / pageSize) + 1
            : (totalCount / pageSize);

        if (currentPage > pageNum) {
            //当前页大于总页数，重置到首页
            currentPage = 1;
        }
        map.put("pageSize", String.valueOf(pageSize));
        map.put("offset", String.valueOf((currentPage - 1) * pageSize));

        List<ImagesDo> list = getSqlSession().selectList(NAMESPACE + ".pageQuery", map);
        PageList<ImagesDo> pageList = new PageList<ImagesDo>();
        pageList.setResultList(list);
        pageList.setCurrentPage(currentPage);
        pageList.setPageNum(pageNum);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(totalCount);

        return pageList;
    }
}
