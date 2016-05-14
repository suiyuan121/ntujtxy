package cn.edu.ntu.jtxy.core.dao.wx;

import cn.edu.ntu.jtxy.core.model.wx.PointDo;
import cn.edu.ntu.jtxy.core.repository.wx.model.PointInfo;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: PointDao.java, v 0.1 2016年4月14日 下午1:45:20 {jin.zhang@witontek.com} Exp $
 */
public interface PointDao {

    /**
     * 
     * @param pointDo
     * @return
     */
    public long add(PointDo pointDo);

    /**
     * 
     * @param id
     * @return
     */
    public PointDo lockById(long id);

    /**
     * 
     * @param pointInfo
     * @return
     */
    public boolean update(PointDo pointInfo);

    /**
     * 
     * @param uid
     * @param code
     * @return
     */
    public PointDo getByUidAndType(String uid, String code);

    /**
     * 
     * @param pageSize
     * @param currentPage
     * @param stuNo
     * @param stuName
     * @return
     */
    public PageList<PointInfo> pageQuery(int pageSize, int currentPage, String stuNo, String stuName);

    /**
     * 
     * @param uid
     * @return
     */
    public int getTotalByUid(String uid);
}
