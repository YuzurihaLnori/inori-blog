package inori.blog.transfer.blog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Lnori
 */
@Data
public class BlogRecommendOutVoNext {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


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


}
