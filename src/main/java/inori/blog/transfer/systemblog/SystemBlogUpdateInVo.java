package inori.blog.transfer.systemblog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemBlogUpdateInVo {

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
     * 分类
     */
    @NotNull(message = "参数typeId缺失")
    private Integer typeId;


    /**
     * 标记
     */
    @NotBlank(message = "参数flag缺失")
    private String flag;


    /**
     * 首图
     */
    @NotNull(message = "参数firstPicture缺失")
    private Integer firstPicture;


    /**
     * 描述
     */
    @NotBlank(message = "参数description缺失")
    private String description;


    /**
     * 内容
     */
    @NotBlank(message = "参数content缺失")
    private String content;


}
