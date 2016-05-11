package cn.edu.ntu.jtxy.web.controller.wx.ajax.response;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.BaseModel;
import cn.edu.ntu.jtxy.core.repository.wx.model.PointInfo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PointQueryAjaxResponse.java, v 0.1 2016年5月6日 下午10:28:57 zhangjinntu@163.com Exp $
 */
public class PointQueryAjaxResponse extends BaseModel {

    /**  */
    private static final long serialVersionUID = -5475758043616574606L;

    private List<PointInfo>   list;

    public List<PointInfo> getList() {
        return list;
    }

    public void setList(List<PointInfo> list) {
        this.list = list;
    }

}
