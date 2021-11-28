package inori.blog.serivce;

import inori.blog.transfer.index.IndexListInVo;
import inori.blog.transfer.index.IndexListOutVo;
import inori.blog.transfer.index.IndexRecommendListInVo;
import inori.blog.transfer.index.IndexRecommendListOutVo;

/**
 * @author Lnori
 */
public interface IIndexService {

    /**
     * 博客列表
     *
     * @param inVo 条件
     * @return 列表
     */
    IndexListOutVo indexList(IndexListInVo inVo);

    /**
     * 推荐博客列表
     *
     * @param inVo 条件
     * @return 列表
     */
    IndexRecommendListOutVo indexRecommendList(IndexRecommendListInVo inVo);

}
