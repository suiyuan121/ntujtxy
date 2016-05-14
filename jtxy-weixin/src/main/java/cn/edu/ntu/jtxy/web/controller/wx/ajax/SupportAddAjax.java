package cn.edu.ntu.jtxy.web.controller.wx.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.ntu.jtxy.core.repository.wx.ImagesRepository;
import cn.edu.ntu.jtxy.web.SystemConstants;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: SupportAddAjax.java, v 0.1 2016年5月12日 下午10:32:50 zhangjinntu@163.com Exp $
 */
@Controller
@RequestMapping(value = "prise.json")
public class SupportAddAjax implements SystemConstants {
    /**  */
    private static final Logger logger = LoggerFactory.getLogger(SupportAddAjax.class);

    @Autowired
    private ImagesRepository    imagesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(ModelMap map, int supportAmount, int imageId) {
        logger.info("点赞   doGet  supportAmount={},imageId={},", supportAmount, imageId);

        if (supportAmount <= 0 || imageId <= 0) {
            logger.warn("点赞异常   supportAmount={},imageId={}", supportAmount, imageId);
            map.addAttribute("msg", ERROR);
        }
        int ret = imagesRepository.updateSupportAmountById(imageId);
        if (ret <= 0) {
            map.addAttribute("msg", ERROR);
        }
        map.addAttribute("msg", SUCCESS);
    }
}
