package inori.blog.serivce;

import inori.blog.common.controller.BaseRestController;
import inori.blog.transfer.systemtype.*;

/**
 * @author Inori
 */
public interface ISystemTypeService {

    /**
     * 分类列表
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return 列表
     */
    SystemTypeListOutVo systemTypeList(BaseRestController controller, SystemTypeListInVo inVo);

    /**
     * 录入分类
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemTypeCreate(BaseRestController controller, SystemTypeCreateInVo inVo);

    /**
     * 编辑分类
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemTypeUpdate(BaseRestController controller, SystemTypeUpdateInVo inVo);

    /**
     * 删除分类
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemTypeDelete(BaseRestController controller, SystemTypeDeleteInVo inVo);

}
