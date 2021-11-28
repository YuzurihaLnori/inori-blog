package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.dao.TypeMapper;
import inori.blog.serivce.ITypeService;
import inori.blog.transfer.type.TypeListInVo;
import inori.blog.transfer.type.TypeListOutVo;
import inori.blog.transfer.type.TypeListOutVoRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lnori
 */
@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;


    @Override
    public TypeListOutVo typeList(TypeListInVo inVo) {
        Page<TypeListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<TypeListOutVoRecords> recordsList = typeMapper.typeList(page, inVo);

        TypeListOutVo outVo = new TypeListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }
}
