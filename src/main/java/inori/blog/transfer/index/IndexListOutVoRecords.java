package inori.blog.transfer.index;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class IndexListOutVoRecords {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 首图路径
     */
    @NotBlank(message = "参数firstPicturePath缺失")
    private String firstPicturePath;


    /**
     * 标题
     */
    @NotBlank(message = "参数title缺失")
    private String title;


    /**
     * 热度
     */
    @NotNull(message = "参数views缺失")
    private Integer views;


    /**
     * 评论条数
     */
    @NotNull(message = "参数commentTotal缺失")
    private Integer commentTotal;


    /**
     * 分类名称
     */
    @NotBlank(message = "参数typeName缺失")
    private String typeName;


    /**
     * 描述
     */
    @NotBlank(message = "参数description缺失")
    private String description;


    /**
     * 创建时间
     */
    @NotBlank(message = "参数createTime缺失")
    private String createTime;


}
