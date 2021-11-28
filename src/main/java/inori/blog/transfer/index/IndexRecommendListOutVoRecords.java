package inori.blog.transfer.index;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class IndexRecommendListOutVoRecords {

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
     * 描述
     */
    @NotBlank(message = "参数description缺失")
    private String description;


}
