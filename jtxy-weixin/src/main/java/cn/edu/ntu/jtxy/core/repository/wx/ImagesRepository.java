package cn.edu.ntu.jtxy.core.repository.wx;

import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.cond.ImagesPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

public interface ImagesRepository {

    /**
     * 
     * @param imagesDo
     * @return
     */
    public long add(ImagesDo imagesDo);

    /**
     * 
     * @param cond
     * @return
     */
    public PageList<ImagesDo> pageQuery(ImagesPageQueryCond cond);

    /**
     * 
     * @param id
     */
    public ImagesDo getById(int id);

    /**
     * 
     * @param imageId
     * @param supportAmount
     * @return
     */
    public int updateSupportAmountById(int imageId);

}
