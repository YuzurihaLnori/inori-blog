package inori.blog.transfer.archives;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */
@Data
public class ArchivesListOutVoRecords {

    /**
     * ID
     */
    @NotNull(message = "参数id缺失")
    private Integer id;


    /**
     * 标题
     */
    @NotBlank(message = "参数title缺失")
    private String title;


    /**
     * 创建时间
     */
    @NotBlank(message = "参数createTime缺失")
    private String createTime;


}
