package cn.edu.ntu.jtxy.resp;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.edu.ntu.jtxy.BaseTest;
import cn.edu.ntu.jtxy.core.model.mng.NewsDo;
import cn.edu.ntu.jtxy.core.repository.mng.NewsRepository;
import cn.edu.ntu.jtxy.core.repository.mng.cond.NewsPageQueryCond;
import cn.edu.ntu.jtxy.core.repository.wx.pagelist.PageList;

/**
 * 
 * @author zhangjinntu@163.com
 * @version $Id: NewsRepositoryTest.java, v 0.1 2016年5月1日 下午2:17:26 zhangjinntu@163.com Exp $
 */
public class NewsRepositoryTest extends BaseTest {

    @Test
    public void test_add() {
        NewsRepository resp = getContext().getBean(NewsRepository.class);

        NewsDo newsDo = new NewsDo();
        newsDo.setMedia_id(UUID.randomUUID().toString());
        newsDo.setAuthor("zhangjin");
        newsDo.setDigest("摘要");
        newsDo.setTitle("title");
        newsDo.setUpdateTime(String.valueOf(System.currentTimeMillis()));
        newsDo
            .setUrl("http://mp.weixin.qq.com/s?__biz=MzI4NTAzMTg0NQ==&mid=223902505&idx=2&sn=034afd4bd72c9b26df810f4099b47d13#rd");
        long ret = resp.add(newsDo);
        logger.info("xxxxxxxxxxxxxxxxxret={}", ret);

    }

    @Test
    public void test_getByCond() {
        NewsRepository resp = getContext().getBean(NewsRepository.class);

        List<NewsDo> ret = resp.getByMediaId("vSw0XuvDSp4R_hSS4DPd9-aW7GEyc-iqpXpMQUgifpM");
        logger.info("xxxxxxlist={}", ret);
    }

    @Test
    public void test_pageQuery() {
        NewsRepository resp = getContext().getBean(NewsRepository.class);

        NewsPageQueryCond cond = new NewsPageQueryCond();
        cond.setPageSize(5);
        cond.setCurrentPage(1);
        PageList<String> pageList = resp.pageQuery(cond);
        logger.info("zxxxxpageList={}", pageList);
    }

}
