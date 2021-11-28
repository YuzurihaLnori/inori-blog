package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.common.controller.BaseRestController;
import inori.blog.dao.SystemPictureMapper;
import inori.blog.serivce.ISystemPictureService;
import inori.blog.transfer.systeimpicture.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Inori
 */
@Service
public class SystemPictureServiceImpl implements ISystemPictureService {
    @Autowired
    private SystemPictureMapper systemPictureMapper;

    @Value("${inori.oss.httpBase}")
    private String httpBase;


    @Override
    public SystemPictureListOutVo systemPictureList(BaseRestController controller, SystemPictureListInVo inVo) {
        Page<SystemPictureListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<SystemPictureListOutVoRecords> recordsList = systemPictureMapper.systemPictureList(page, inVo);

        recordsList.forEach(m -> m.setPicturePath(httpBase + m.getPicturePath()));

        SystemPictureListOutVo outVo = new SystemPictureListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


    @Override
    public void systemPictureCreate(BaseRestController controller, SystemPictureCreateInVo inVo) {
        systemPictureMapper.systemPictureCreate(inVo);
    }


    @Override
    public void systemPictureUpdate(BaseRestController controller, SystemPictureUpdateInVo inVo) {
        systemPictureMapper.systemPictureUpdate(inVo);
    }


    @Override
    public void systemPictureDelete(BaseRestController controller, SystemPictureDeleteInVo inVo) {
        systemPictureMapper.systemPictureDelete(inVo);
    }


}
