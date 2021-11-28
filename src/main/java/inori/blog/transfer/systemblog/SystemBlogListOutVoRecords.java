package inori.blog.transfer.systemblog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemBlogListOutVoRecords {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 标题
     */
    @NotBlank(message = "参数title缺失")
    private String title;


    /**
     * 分类名称
     */
    @NotBlank(message = "参数typeName缺失")
    private String typeName;


    /**
     * 是否推荐
     */
    @NotNull(message = "参数recommend缺失")
    private Integer recommend;


    /**
     * 状态
     */
    @NotNull(message = "参数status缺失")
    private Integer status;


    /**
     * 更新时间
     */
    @NotBlank(message = "参数updateTime缺失")
    private String updateTime;


}
