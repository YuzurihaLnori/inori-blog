package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.dao.ArchivesMapper;
import inori.blog.serivce.IArchivesService;
import inori.blog.transfer.archives.ArchivesListInVo;
import inori.blog.transfer.archives.ArchivesListOutVo;
import inori.blog.transfer.archives.ArchivesListOutVoRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lnori
 */
@Service
public class ArchivesServiceImpl implements IArchivesService {
    @Autowired
    private ArchivesMapper archivesMapper;


    @Override
    public ArchivesListOutVo archivesList(ArchivesListInVo inVo) {
        Page<ArchivesListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<ArchivesListOutVoRecords> recordsList = archivesMapper.archivesList(page, inVo);

        ArchivesListOutVo outVo = new ArchivesListOutVo();
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


}
