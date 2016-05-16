package cn.edu.ntu.jtxy.web.controller.wx.ajax.response;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.BaseModel;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsQueryAjaxResponse.java, v 0.1 2016年5月15日 下午2:53:09 zhangjinntu@163.com Exp $
 */
public class NewsQueryAjaxResponse extends BaseModel {

    /**  */
    private static final long serialVersionUID = 2178107508503361284L;

    private List<NewsDo>      list;

    public List<NewsDo> getList() {
        return list;
    }

    public void setList(List<NewsDo> list) {
        this.list = list;
    }

}
