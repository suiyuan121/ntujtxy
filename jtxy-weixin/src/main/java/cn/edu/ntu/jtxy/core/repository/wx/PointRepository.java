package cn.edu.ntu.jtxy.core.repository.wx;

import cn.edu.ntu.jtxy.core.model.wx.PointDo;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: PointRepository.java, v 0.1 2016年4月14日 下午2:22:22 {jin.zhang@witontek.com} Exp $
 */
public interface PointRepository {

    /**
     * 
     * @param pointDo
     * @return
     */
    public long add(PointDo pointDo);

    /**
     * 
     * @param uid
     * @param type
     * @return
     */
    public PointDo getByUidAndType(String uid, PointDo.PointTypeEnum poinType);

    /**
     * 
     * @param id
     * @return
     */
    public PointDo lockById(long id);

    /**
     * 
     * @param uid
     * @param poinType
     * @param amount
     * @return
     */
    public boolean update(PointDo pointInfo);

}
