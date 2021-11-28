package inori.blog.transfer.search;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Inori
 */
@Data
@Document(indexName = "search", type = "docs", shards = 1, replicas = 0)
public class SearchListOutVoRecords {

    /**
     * ID
     */
    @Id
    private Integer id;


    /**
     * 查询条件
     */
    private String all;


    /**
     * 首图url
     */
    private String firstPicturePath;


    /**
     * 标题
     */
    private String title;


    /**
     * 热度
     */
    private Integer views;


    /**
     * 评论总数
     */
    private Integer commentTotal;


    /**
     * 分类名称
     */
    @Field(type = FieldType.Keyword)
    private String typeName;


    /**
     * 描述
     */
    private String description;


    /**
     * 创建时间
     */
    private String createTime;


}
