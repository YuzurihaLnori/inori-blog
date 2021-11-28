package inori.blog.serivce;

import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.transfer.systemblog.*;

/**
 * @author Inori
 */
public interface ISystemBlogService {

    /**
     * 博客列表
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return 列表
     */
    SystemBlogListOutVo systemBlogList(BaseRestController controller, SystemBlogListInVo inVo);


    /**
     * 博客录入
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemBlogCreate(BaseRestController controller, SystemBlogCreateInVo inVo);

    /**
     * 获取博客
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return 博客
     */
    SystemBlogUpdateGetOutVo systemBlogUpdateGet(BaseRestController controller, SystemBlogUpdateGetInVo inVo);

    /**
     * 博客编辑
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemBlogUpdate(BaseRestController controller, SystemBlogUpdateInVo inVo);

    /**
     * 博客删除
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemBlogDelete(BaseRestController controller, SystemBlogDeleteInVo inVo);

    /**
     * 博客推荐
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return Json
     */
    RestResponse systemBlogRecommend(BaseRestController controller, SystemBlogRecommendInVo inVo);

}
