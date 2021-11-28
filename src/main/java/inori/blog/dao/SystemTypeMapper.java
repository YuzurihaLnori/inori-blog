package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.systemtype.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Inori
 */
public interface SystemTypeMapper {

    /**
     * 分类列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<SystemTypeListOutVoRecords> systemTypeList(@Param("page") Page<SystemTypeListOutVoRecords> page, @Param("inVo") SystemTypeListInVo inVo);


    /**
     * 录入分类
     *
     * @param inVo 条件
     */
    void systemTypeCreate(SystemTypeCreateInVo inVo);


    /**
     * 编辑分类
     *
     * @param inVo 条件
     */
    void systemTypeUpdate(SystemTypeUpdateInVo inVo);


    /**
     * 删除分类
     *
     * @param inVo 条件
     */
    void systemTypeDelete(SystemTypeDeleteInVo inVo);


}
