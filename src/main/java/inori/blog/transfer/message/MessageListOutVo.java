package inori.blog.transfer.message;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Inori
 */
@Data
public class MessageListOutVo {

    /**
     * 总条数
     */
    @NotNull(message = "参数totalNumber缺失")
    private Integer totalNumber;


    /**
     * 总数
     */
    @NotNull(message = "参数total缺失")
    private Integer total;


    /**
     * 记录
     */
    @NotNull(message = "参数records缺失")
    private List<MessageListOutVoRecords> records;


}
