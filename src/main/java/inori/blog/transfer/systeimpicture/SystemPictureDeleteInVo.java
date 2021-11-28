package inori.blog.transfer.systeimpicture;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemPictureDeleteInVo {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


}
