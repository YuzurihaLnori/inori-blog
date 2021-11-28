package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.systemblog.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Inori
 */
public interface SystemBlogMapper {

    /**
     * 博客列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<SystemBlogListOutVoRecords> systemBlogList(@Param("page") Page<SystemBlogListOutVoRecords> page, @Param("inVo") SystemBlogListInVo inVo);


    /**
     * 博客录入
     *
     * @param inVo 条件
     */
    void systemBlogCreate(SystemBlogCreateInVo inVo);


    /**
     * 获取博客
     *
     * @param inVo 条件
     * @return 博客
     */
    SystemBlogUpdateGetOutVo systemBlogUpdateGet(SystemBlogUpdateGetInVo inVo);


    /**
     * 博客编辑
     *
     * @param inVo 条件
     */
    void systemBlogUpdate(SystemBlogUpdateInVo inVo);


    /**
     * 博客删除
     *
     * @param inVo 条件
     */
    void systemBlogDelete(SystemBlogDeleteInVo inVo);


    /**
     * 查询推荐数量
     *
     * @return 数量
     */
    Integer systemBlogRecommendCount();


    /**
     * 博客推荐
     *
     * @param inVo 条件
     */
    void systemBlogRecommend(SystemBlogRecommendInVo inVo);


}
