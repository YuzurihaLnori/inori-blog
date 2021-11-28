package inori.blog.model;

import lombok.Data;

/**
 * @author Inori
 */
@Data
public class OssFile {
    private String url;
    private String path;
    private Integer resId;
    private String fileName;
    private String typeCode;
}
