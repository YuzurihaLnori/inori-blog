package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.common.controller.BaseRestController;
import inori.blog.dao.SystemTypeMapper;
import inori.blog.serivce.ISystemTypeService;
import inori.blog.transfer.systemtype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Inori
 */
@Service
public class SystemTypeServiceImpl implements ISystemTypeService {
    @Autowired
    private SystemTypeMapper systemTypeMapper;


    @Override
    public SystemTypeListOutVo systemTypeList(BaseRestController controller, SystemTypeListInVo inVo) {
        Page<SystemTypeListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<SystemTypeListOutVoRecords> recordsList = systemTypeMapper.systemTypeList(page, inVo);

        SystemTypeListOutVo outVo = new SystemTypeListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


    @Override
    public void systemTypeCreate(BaseRestController controller, SystemTypeCreateInVo inVo) {
        systemTypeMapper.systemTypeCreate(inVo);
    }


    @Override
    public void systemTypeUpdate(BaseRestController controller, SystemTypeUpdateInVo inVo) {
        systemTypeMapper.systemTypeUpdate(inVo);
    }


    @Override
    public void systemTypeDelete(BaseRestController controller, SystemTypeDeleteInVo inVo) {
        systemTypeMapper.systemTypeDelete(inVo);
    }


}
