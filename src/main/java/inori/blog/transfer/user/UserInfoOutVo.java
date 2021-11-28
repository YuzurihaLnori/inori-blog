package inori.blog.transfer.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Lnori
 */
@Data
public class UserInfoOutVo {

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
     * 是否是博主
     */
    private boolean flag = false;


}
