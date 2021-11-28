package inori.blog.transfer.systemblog;

import inori.blog.utils.StringUtil;

/**
 * @author Inori
 */

public class SystemBlogListInVo {

    /**
     * 输入查询
     */
    private String keywords;


    /**
     * 分类
     */
    private Integer typeId;


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


    public String getKeywords() {
        return keywords;
    }

    public void setKeyword(String keywords) {
        this.keywords = keywords;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    /**
     * 0-字符串为空 1-博客ID 2-博客标题
     */
    public Integer isBlogFlag() {
        if (StringUtil.isBlank(this.keywords)) {
            return 0;
        }
        if (StringUtil.isStr2Num(this.keywords)) {
            return 1;
        } else {
            return 2;
        }
    }
}
