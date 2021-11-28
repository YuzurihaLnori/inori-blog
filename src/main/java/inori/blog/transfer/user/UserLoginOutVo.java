package inori.blog.transfer.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Inori
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginOutVo {

    /**
     * token
     */
    @NotBlank(message = "参数token缺失")
    private String token;


}
