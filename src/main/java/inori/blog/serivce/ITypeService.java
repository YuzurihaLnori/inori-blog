package inori.blog.serivce;

import inori.blog.transfer.type.TypeListInVo;
import inori.blog.transfer.type.TypeListOutVo;

/**
 * @author Lnori
 */
public interface ITypeService {

    /**
     * 分类列表
     *
     * @param inVo 条件
     * @return 列表
     */
    TypeListOutVo typeList(TypeListInVo inVo);

}
