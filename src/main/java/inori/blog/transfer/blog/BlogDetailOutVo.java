package inori.blog.transfer.blog;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Lnori
 */
@Data
public class BlogDetailOutVo {

    /**
     * 首图url
     */
    @NotBlank(message = "参数firstPicturePath缺失")
    private String firstPicturePath;


    /**
     * 标题
     */
    @NotBlank(message = "参数title缺失")
    private String title;


    /**
     * html标题
     */
    @NotBlank(message = "参数htmlTitle缺失")
    private String htmlTitle;


    /**
     * 创建时间
     */
    @NotBlank(message = "参数createTime缺失")
    private String createTime;


    /**
     * 内容
     */
    @NotBlank(message = "参数content缺失")
    private String content;


}
