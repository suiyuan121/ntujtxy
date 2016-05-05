package cn.edu.ntu.jtxy.core.component.wx;

import cn.edu.ntu.jtxy.core.component.wx.result.PointOperateResult;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointComponent.java, v 0.1 2016年5月4日 下午5:36:37 zhangjinntu@163.com Exp $
 */
public interface PointComponent {

    /**
     * 
     * @param uid
     * @param amount
     * @return
     */
    public PointOperateResult add(String uid, int amount, PointDo.PointTypeEnum poinType);

    /**
     * 
     * @param uid
     * @param amount
     * @param poinType
     * @return
     */
    public PointOperateResult use(String uid, int amount, PointDo.PointTypeEnum poinType);

}
