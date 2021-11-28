package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.dao.SystemBlogMapper;
import inori.blog.serivce.ISystemBlogService;
import inori.blog.transfer.systemblog.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Inori
 */
@Service
public class SystemBlogServiceImpl implements ISystemBlogService {
    @Autowired
    private SystemBlogMapper systemBlogMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${inori.oss.httpBase}")
    private String httpBase;


    @Override
    public SystemBlogListOutVo systemBlogList(BaseRestController controller, SystemBlogListInVo inVo) {
        Page<SystemBlogListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<SystemBlogListOutVoRecords> recordsList = systemBlogMapper.systemBlogList(page, inVo);

        SystemBlogListOutVo outVo = new SystemBlogListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


    @Override
    public void systemBlogCreate(BaseRestController controller, SystemBlogCreateInVo inVo) {
        systemBlogMapper.systemBlogCreate(inVo);

        amqpTemplate.convertAndSend("search.insert", inVo.getId());
    }


    @Override
    public SystemBlogUpdateGetOutVo systemBlogUpdateGet(BaseRestController controller, SystemBlogUpdateGetInVo inVo) {
        SystemBlogUpdateGetOutVo outVo = systemBlogMapper.systemBlogUpdateGet(inVo);
        outVo.setFirstPicturePath(httpBase + outVo.getFirstPicturePath());
        return outVo;
    }


    @Override
    public void systemBlogUpdate(BaseRestController controller, SystemBlogUpdateInVo inVo) {
        systemBlogMapper.systemBlogUpdate(inVo);

        amqpTemplate.convertAndSend("search.update", inVo.getId());
    }


    @Override
    public void systemBlogDelete(BaseRestController controller, SystemBlogDeleteInVo inVo) {
        systemBlogMapper.systemBlogDelete(inVo);

        amqpTemplate.convertAndSend("search.delete", inVo.getId());
    }


    @Override
    public RestResponse systemBlogRecommend(BaseRestController controller, SystemBlogRecommendInVo inVo) {
        if (inVo.getRecommend() == 1) {
            if (systemBlogMapper.systemBlogRecommendCount() == 3) {
                return RestResponse.fail("推荐以上限");
            }
        }

        systemBlogMapper.systemBlogRecommend(inVo);
        return RestResponse.success();
    }


}
