package inori.blog.serivce;

import inori.blog.common.controller.BaseRestController;
import inori.blog.transfer.systeimpicture.*;

/**
 * @author Inori
 */
public interface ISystemPictureService {

    /**
     * 照片列表
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return 列表
     */
    SystemPictureListOutVo systemPictureList(BaseRestController controller, SystemPictureListInVo inVo);

    /**
     * 录入照片
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemPictureCreate(BaseRestController controller, SystemPictureCreateInVo inVo);

    /**
     * 编辑照片
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemPictureUpdate(BaseRestController controller, SystemPictureUpdateInVo inVo);

    /**
     * 删除照片
     *
     * @param controller 枷锁
     * @param inVo       条件
     */
    void systemPictureDelete(BaseRestController controller, SystemPictureDeleteInVo inVo);

}
