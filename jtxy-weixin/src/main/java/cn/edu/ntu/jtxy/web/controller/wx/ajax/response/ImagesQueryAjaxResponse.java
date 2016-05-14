package cn.edu.ntu.jtxy.web.controller.wx.ajax.response;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.BaseModel;
import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: ImagesQueryAjaxResponse.java, v 0.1 2016年5月12日 上午10:20:58 zhangjinntu@163.com Exp $
 */
public class ImagesQueryAjaxResponse extends BaseModel {

    /**  */
    private static final long serialVersionUID = -5475758043616574606L;

    private List<ImagesDo>    list;

    public List<ImagesDo> getList() {
        return list;
    }

    public void setList(List<ImagesDo> list) {
        this.list = list;
    }

}
