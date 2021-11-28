package inori.blog.repository;

import inori.blog.transfer.search.SearchListOutVoRecords;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lnori
 */
@Repository
public interface SearchRepository extends ElasticsearchRepository<SearchListOutVoRecords, Integer> {
}
