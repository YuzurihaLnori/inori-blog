package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.archives.ArchivesListInVo;
import inori.blog.transfer.archives.ArchivesListOutVoRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lnori
 */
public interface ArchivesMapper {

    /**
     * 归档列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<ArchivesListOutVoRecords> archivesList(@Param("page") Page<ArchivesListOutVoRecords> page, @Param("inVo") ArchivesListInVo inVo);


}
