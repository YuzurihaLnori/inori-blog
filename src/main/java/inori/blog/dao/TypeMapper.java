package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.type.TypeListInVo;
import inori.blog.transfer.type.TypeListOutVoRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lnori
 */
public interface TypeMapper {

    /**
     * 分类列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<TypeListOutVoRecords> typeList(@Param("page") Page<TypeListOutVoRecords> page, @Param("inVo") TypeListInVo inVo);


}
