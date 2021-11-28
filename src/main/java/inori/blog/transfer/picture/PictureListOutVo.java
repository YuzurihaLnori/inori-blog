package inori.blog.transfer.picture;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Inori
 */
@Data
public class PictureListOutVo {

    /**
     * 总数
     */
    @NotNull(message = "参数total缺失")
    private Integer total;


    /**
     * 记录
     */
    @NotNull(message = "参数records缺失")
    private List<PictureListOutVoRecords> records;


}
