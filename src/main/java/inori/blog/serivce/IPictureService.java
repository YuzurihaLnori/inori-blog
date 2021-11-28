package inori.blog.serivce;

import inori.blog.transfer.picture.PictureListInVo;
import inori.blog.transfer.picture.PictureListOutVo;

/**
 * @author Lnori
 */
public interface IPictureService {

    /**
     * 图片列表
     *
     * @param inVo 条件
     * @return 列表
     */
    PictureListOutVo pictureList(PictureListInVo inVo);

}
