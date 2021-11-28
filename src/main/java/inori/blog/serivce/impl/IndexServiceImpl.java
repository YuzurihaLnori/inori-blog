package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.dao.IndexMapper;
import inori.blog.serivce.IIndexService;
import inori.blog.transfer.index.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lnori
 */
@Service
public class IndexServiceImpl implements IIndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Value("${inori.oss.httpBase}")
    private String httpBase;


    @Override
    public IndexListOutVo indexList(IndexListInVo inVo) {
        Page<IndexListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<IndexListOutVoRecords> recordsList = indexMapper.indexList(page, inVo);

        recordsList.forEach(m -> m.setFirstPicturePath(httpBase + m.getFirstPicturePath()));

        IndexListOutVo outVo = new IndexListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


    @Override
    public IndexRecommendListOutVo indexRecommendList(IndexRecommendListInVo inVo) {
        Page<IndexRecommendListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<IndexRecommendListOutVoRecords> recordsList = indexMapper.indexRecommendList(page, inVo);

        recordsList.forEach(m -> m.setFirstPicturePath(httpBase + m.getFirstPicturePath()));

        IndexRecommendListOutVo outVo = new IndexRecommendListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


}
