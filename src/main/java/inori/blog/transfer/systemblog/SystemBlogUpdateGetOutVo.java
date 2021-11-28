package inori.blog.transfer.systemblog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemBlogUpdateGetOutVo {

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
     * 分类名称
     */
    @NotNull(message = "参数typeName缺失")
    private String typeName;


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
     * 首图路径
     */
    @NotNull(message = "参数firstPicturePath缺失")
    private String firstPicturePath;


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


    /**
     * 状态
     */
    @NotNull(message = "参数status缺失")
    private Integer status;


}
