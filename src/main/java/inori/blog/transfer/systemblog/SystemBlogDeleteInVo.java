package inori.blog.transfer.systemblog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class SystemBlogDeleteInVo {

    /**
     * ID
     */
    @NotNull
    private Integer id;


}
