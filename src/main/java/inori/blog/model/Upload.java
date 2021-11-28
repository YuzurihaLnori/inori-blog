package inori.blog.model;

import lombok.Data;


/**
 * @author Inori
 */
@Data
public class Upload {
    private Long resId;
    private String resUrl;

    public Upload(Long resId, String resUrl) {
        setResId(resId);
        setResUrl(resUrl);
    }
}
