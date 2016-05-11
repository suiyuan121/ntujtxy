package cn.edu.ntu.jtxy.core.dao.wx;

import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

public interface ImagesDao {

    /**
     * 
     * @return
     */
    public long add(ImagesDo imagesDo);

    /**
     * 
     * @param type
     * @param uid
     * @param orderType
     * @return
     */
    public PageList<ImagesDo> pageQuery(int pageSize, int currentPage, String type, String uid,
                                        String orderType);

}
