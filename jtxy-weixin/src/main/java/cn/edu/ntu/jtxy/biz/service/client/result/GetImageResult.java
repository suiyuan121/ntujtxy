package cn.edu.ntu.jtxy.biz.service.client.result;

import cn.edu.ntu.jtxy.core.model.BaseResult;

/**
 * 
 * @author {jin.zhang@witontek.com}
 * @version $Id: QueryNewsResult.java, v 0.1 2016年4月29日 下午3:47:12 {jin.zhang@witontek.com} Exp $
 */
public class GetImageResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = -7900401613592832965L;

    private String            imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
