package inori.blog.transfer.message;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Inori
 */
@Data
public class MessageListOutVoRecords {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 父ID
     */
    @NotNull(message = "参数pid缺失")
    private Integer pid;


    /**
     * 头像url
     */
    @NotBlank(message = "参数avatar缺失")
    private String avatar;


    /**
     * 昵称
     */
    @NotBlank(message = "参数nickName缺失")
    private String nickName;


    /**
     * 邮箱
     */
    @NotBlank(message = "参数email缺失")
    private String email;


    /**
     * 内容
     */
    @NotBlank(message = "参数content缺失")
    private String content;


    /**
     * 是否是博主
     */
    @NotNull(message = "参数isBlogger缺失")
    private Integer isBlogger;


    /**
     * 创建时间
     */
    @NotBlank(message = "参数createTime缺失")
    private String createTime;


    /**
     * 留言回复列表
     */
    private List<MessageListOutVoRecords> messageReplyList;


}
