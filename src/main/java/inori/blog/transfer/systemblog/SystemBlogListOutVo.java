package inori.blog.transfer.systemblog;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Inori
 */
@Data
public class SystemBlogListOutVo {

    /**
     * 总数
     */
    @NotNull(message = "参数total缺失")
    private Integer total;


    /**
     * 记录
     */
    @NotNull(message = "参数records缺失")
    private List<SystemBlogListOutVoRecords> records;


}
