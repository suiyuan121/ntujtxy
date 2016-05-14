package cn.edu.ntu.jtxy.core.repository.wx.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ntu.jtxy.core.dao.wx.ImagesDao;
import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;
import cn.edu.ntu.jtxy.core.repository.wx.cond.ImagesPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

public class ImagesRepositoryImpl implements ImagesRepository {

    private static final Logger logger = LoggerFactory.getLogger(PointRecordRepositoryImpl.class);

    @Autowired
    private ImagesDao           imagesDao;

    @Override
    public long add(ImagesDo imagesDo) {
        logger.info("图片新增  imagesDo={}", imagesDo);
        if (imagesDo == null) {
            return -1;
        }
        return imagesDao.add(imagesDo);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository#pageQuery(cn.edu.ntu.jtxy.core.repository.wx.cond.ImagesPageQueryCond)
     */
    @Override
    public PageList<ImagesDo> pageQuery(ImagesPageQueryCond cond) {
        logger.info("图片分页查询  cond={}", cond);
        if (cond == null) {
            return null;
        }
        return imagesDao.pageQuery(cond.getPageSize(), cond.getCurrentPage(), cond.getType(),
            cond.getUid(), cond.getOrderType());
    }

    @Override
    public ImagesDo getById(int id) {
        logger.info("图片查询 id={}", id);
        if (id <= 0) {
            return null;
        }
        return imagesDao.getById(id);
    }

    /** 
     * @see cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository#updateSupportAmountById(int, int)
     */
    @Override
    public int updateSupportAmountById(int imageId) {
        logger.info("点赞增加   imageId={}", imageId);
        if (imageId <= 0) {
            return -1;
        }
        return imagesDao.updateSupportAmountById(imageId);
    }
}
