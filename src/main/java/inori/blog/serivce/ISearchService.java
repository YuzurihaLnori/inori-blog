package inori.blog.serivce;

import inori.blog.transfer.search.SearchListInVo;
import inori.blog.transfer.search.SearchListOutVo;

/**
 * @author Lnori
 */
public interface ISearchService {


    /**
     * 查询结果列表
     *
     * @param inVo 条件
     * @return 列表
     */
    SearchListOutVo searchList(SearchListInVo inVo);

    /**
     * 索引库新增或修改
     *
     * @param id ID
     */
    void searchCreateOrUpdate(Integer id);

    /**
     * 索引库删除
     *
     * @param id ID
     */
    void searchDelete(Integer id);

}
