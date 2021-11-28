package inori.blog.transfer.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Inori
 */
@Data
public class UserLoginInVo {

    /**
     * 账号
     */
    @NotBlank(message = "参数account缺失")
    private String account;


    /**
     * 密码
     */
    @NotBlank(message = "参数password缺失")
    private String password;


}
