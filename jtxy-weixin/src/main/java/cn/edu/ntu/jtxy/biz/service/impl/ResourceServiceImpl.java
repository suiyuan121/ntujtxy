package cn.edu.ntu.jtxy.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import cn.edu.ntu.jtxy.biz.service.ResourceService;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: ResourceService.java, v 0.1 2016年5月12日 下午1:15:15 zhangjinntu@163.com Exp $
 */
public class ResourceServiceImpl implements ResourceService, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    /**图片地址  */
    private Resource            imagePath;

    public void setImagePath(Resource imagePath) {
        this.imagePath = imagePath;
    }


    @Override
    public Resource getImagePath() {
        return this.imagePath;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("资源路径初始化....");
        logger.info("imagePath = {}", this.imagePath);
    }
}
