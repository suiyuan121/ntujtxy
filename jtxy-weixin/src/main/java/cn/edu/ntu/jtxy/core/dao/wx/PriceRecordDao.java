package cn.edu.ntu.jtxy.core.dao.wx;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;
import cn.edu.ntu.jtxy.core.repository.wx.model.PrizeInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

public interface PriceRecordDao {

    /**
    * 
    * @param priceRecordDo
    * @return
    */
    public long add(PriceRecordDo priceRecordDo);

    /**
     * 
     * @param uid
     * @return
     */
    public List<PriceRecordDo> getByUid(String uid);

    /**
     * 
     * @param pageSize
     * @param pageNum
     * @param uid
     * @return
     */
    public PageList<PriceRecordDo> pageQuery(int pageSize, int currentPage, String uid);

    /**
     * 
     * @param pageSize
     * @param currentPage
     * @param stuName
     * @param stuNo
     * @param type
     * @return
     */
    public PageList<PrizeInfo> pageQuery(int pageSize, int currentPage, String stuName,
                                         String stuNo, String type);

}
