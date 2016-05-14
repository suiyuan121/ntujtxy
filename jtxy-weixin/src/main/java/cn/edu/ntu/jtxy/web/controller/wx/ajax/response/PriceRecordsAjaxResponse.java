package cn.edu.ntu.jtxy.web.controller.wx.ajax.response;

import java.util.List;

import cn.edu.ntu.jtxy.core.model.BaseModel;
import cn.edu.ntu.jtxy.core.model.wx.PriceRecordDo;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: PriceRecordsAjaxResponse.java, v 0.1 2016年5月13日 上午8:40:27 zhangjinntu@163.com Exp $
 */
public class PriceRecordsAjaxResponse extends BaseModel {

    /**  */
    private static final long   serialVersionUID = 6693581548613916940L;

    private List<PriceRecordDo> list;

    public List<PriceRecordDo> getList() {
        return list;
    }

    public void setList(List<PriceRecordDo> list) {
        this.list = list;
    }

}
