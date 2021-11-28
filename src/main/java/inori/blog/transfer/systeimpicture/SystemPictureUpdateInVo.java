package inori.blog.transfer.systeimpicture;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemPictureUpdateInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 照片
     */
    @NotNull(message = "参数picture缺失")
    private Integer picture;


    /**
     * 标题
     */
    @NotBlank(message = "参数title缺失")
    private String title;


    /**
     * 地址
     */
    @NotBlank(message = "参数address缺失")
    private String address;


    /**
     * 描述
     */
    @NotBlank(message = "参数description缺失")
    private String description;


}
