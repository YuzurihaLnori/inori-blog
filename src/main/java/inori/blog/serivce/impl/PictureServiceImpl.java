package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.dao.PictureMapper;
import inori.blog.serivce.IPictureService;
import inori.blog.transfer.picture.PictureListInVo;
import inori.blog.transfer.picture.PictureListOutVo;
import inori.blog.transfer.picture.PictureListOutVoRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lnori
 */
@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Value("${inori.oss.httpBase}")
    private String httpBase;


    @Override
    public PictureListOutVo pictureList(PictureListInVo inVo) {
        Page<PictureListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<PictureListOutVoRecords> recordsList = pictureMapper.pictureList(page, inVo);

        recordsList.forEach(m -> m.setPicturePath(httpBase + m.getPicturePath()));

        PictureListOutVo outVo = new PictureListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


}
