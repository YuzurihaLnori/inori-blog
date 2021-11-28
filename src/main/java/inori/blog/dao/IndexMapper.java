package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.index.IndexListInVo;
import inori.blog.transfer.index.IndexListOutVoRecords;
import inori.blog.transfer.index.IndexRecommendListInVo;
import inori.blog.transfer.index.IndexRecommendListOutVoRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lnori
 */
public interface IndexMapper {

    /**
     * 博客列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<IndexListOutVoRecords> indexList(@Param("page") Page<IndexListOutVoRecords> page, @Param("inVo") IndexListInVo inVo);


    /**
     * 推荐博客列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<IndexRecommendListOutVoRecords> indexRecommendList(@Param("page") Page<IndexRecommendListOutVoRecords> page, @Param("inVo") IndexRecommendListInVo inVo);


}
