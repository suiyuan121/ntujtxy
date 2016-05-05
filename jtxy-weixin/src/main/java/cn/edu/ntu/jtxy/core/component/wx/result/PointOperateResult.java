package cn.edu.ntu.jtxy.core.component.wx.result;

import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.PointDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointAddResult.java, v 0.1 2016年5月4日 下午5:37:40 zhangjinntu@163.com Exp $
 */
public class PointOperateResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = -3534501566502922315L;

    private PointDo           pointDo;

    public PointDo getPointDo() {
        return pointDo;
    }

    public void setPointDo(PointDo pointDo) {
        this.pointDo = pointDo;
    }

}
