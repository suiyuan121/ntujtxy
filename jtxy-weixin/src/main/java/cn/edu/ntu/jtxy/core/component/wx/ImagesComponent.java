package cn.edu.ntu.jtxy.core.component.wx;

import cn.edu.ntu.jtxy.core.model.BaseResult;
import cn.edu.ntu.jtxy.core.model.wx.ImagesDo;

public interface ImagesComponent {

    /**
     * 
     * @param imagesDo
     * @return
     */
    public abstract BaseResult addImage(ImagesDo imagesDo);

}
