package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.picture.PictureListInVo;
import inori.blog.transfer.picture.PictureListOutVoRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lnori
 */
public interface PictureMapper {

    /**
     * 照片列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<PictureListOutVoRecords> pictureList(@Param("page") Page<PictureListOutVoRecords> page, @Param("inVo") PictureListInVo inVo);


}
