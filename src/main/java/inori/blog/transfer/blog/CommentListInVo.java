package inori.blog.transfer.blog;

import inori.blog.utils.StringUtil;

import javax.validation.constraints.NotNull;

/**
 * @author Inori
 */

public class CommentListInVo {

    /**
     * 博客ID
     */
    @NotNull(message = "参数blogId缺失")
    private Integer blogId;


    /**
     * 页码
     */
    private Integer pageNo;


    /**
     * 每页数量
     */
    private Integer pageSize;


    private static final Integer DEFAULT_PAGE_NO = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;


    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getPageNo() {
        if (StringUtil.isNull(pageNo) || pageNo == -1) {
            return DEFAULT_PAGE_NO;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if (StringUtil.isNull(pageSize) || pageSize == -1) {
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
