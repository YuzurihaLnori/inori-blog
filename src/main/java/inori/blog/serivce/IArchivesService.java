package inori.blog.serivce;

import inori.blog.transfer.archives.ArchivesListInVo;
import inori.blog.transfer.archives.ArchivesListOutVo;

/**
 * @author Lnori
 */
public interface IArchivesService {

    /**
     * 归档列表
     *
     * @param inVo 条件
     * @return 列表
     */
    ArchivesListOutVo archivesList(ArchivesListInVo inVo);

}
