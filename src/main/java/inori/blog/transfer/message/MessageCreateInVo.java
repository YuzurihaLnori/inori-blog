package inori.blog.transfer.message;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Lnori
 */
@Data
public class MessageCreateInVo {

    /**
     * 父ID
     */
    @NotNull(message = "参数pid缺失")
    private Integer pid;


    /**
     * 头像url
     */
    @NotBlank(message = "参数content缺失")
    private String avatar;


    /**
     * 昵称
     */
    @NotBlank(message = "参数nickName缺失")
    private String nickName;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 内容
     */
    @NotBlank(message = "参数content缺失")
    private String content;


}
