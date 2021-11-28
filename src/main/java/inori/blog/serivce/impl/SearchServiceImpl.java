package inori.blog.serivce.impl;

import inori.blog.dao.SearchMapper;
import inori.blog.repository.SearchRepository;
import inori.blog.serivce.ISearchService;
import inori.blog.transfer.search.SearchListInVo;
import inori.blog.transfer.search.SearchListOutVo;
import inori.blog.transfer.search.SearchListOutVoRecords;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author Lnori
 */
@Service
public class SearchServiceImpl implements ISearchService {
    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private SearchRepository repository;

    @Autowired
    private SearchMapper searchMapper;

    @Value("${inori.oss.httpBase}")
    private String httpBase;


    @Override
    public SearchListOutVo searchList(SearchListInVo inVo) {
        //创建查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //分页
        queryBuilder.withPageable(PageRequest.of(inVo.getPageNo() - 1, inVo.getPageSize()));
        //过滤
        queryBuilder.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.wildcardQuery("all", "*" + inVo.getKeywords() + "*")));
        //查询
        AggregatedPage<SearchListOutVoRecords> result = template.queryForPage(queryBuilder.build(), SearchListOutVoRecords.class);

        SearchListOutVo outVo = new SearchListOutVo();
        outVo.setTotal((int) result.getTotalElements());
        outVo.setRecords(result.getContent());
        return outVo;
    }


    @Override
    public void searchCreateOrUpdate(Integer id) {
        SearchListOutVoRecords records = searchMapper.searchDetail(id);
        records.setAll(new StringJoiner(" ").add(records.getTitle()).add(records.getDescription()).toString());
        records.setFirstPicturePath(httpBase + records.getFirstPicturePath());
        repository.save(records);
    }


    @Override
    public void searchDelete(Integer id) {
        repository.deleteById(id);
    }


}
