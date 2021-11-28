package inori.blog.dao;

import inori.blog.transfer.search.SearchListOutVoRecords;

/**
 * @author Lnori
 */
public interface SearchMapper {

    /**
     * 查询博客详情
     *
     * @param id ID
     * @return 详情
     */
    SearchListOutVoRecords searchDetail(Integer id);


}
