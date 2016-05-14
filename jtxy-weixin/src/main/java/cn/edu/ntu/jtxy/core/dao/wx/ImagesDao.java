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

    /**
     * 
     * @param id
     * @return
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
