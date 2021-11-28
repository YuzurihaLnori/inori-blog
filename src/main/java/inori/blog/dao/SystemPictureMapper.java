package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.systeimpicture.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Inori
 */
public interface SystemPictureMapper {

    /**
     * 博客列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<SystemPictureListOutVoRecords> systemPictureList(@Param("page") Page<SystemPictureListOutVoRecords> page, @Param("inVo") SystemPictureListInVo inVo);


    /**
     * 录入照片
     *
     * @param inVo 条件
     */
    void systemPictureCreate(SystemPictureCreateInVo inVo);


    /**
     * 编辑照片
     *
     * @param inVo 条件
     */
    void systemPictureUpdate(SystemPictureUpdateInVo inVo);


    /**
     * 删除照片
     *
     * @param inVo 条件
     */
    void systemPictureDelete(SystemPictureDeleteInVo inVo);


}
