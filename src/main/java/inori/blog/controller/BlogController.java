package inori.blog.controller;

import inori.blog.annotion.AccessLog;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.IBlogService;
import inori.blog.transfer.blog.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lnori
 */
@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @AccessLog("博客详情")
    @PostMapping("/blog/detail")
    public RestResponse blogDetail(@RequestBody(required = true) @Validated BlogDetailInVo inVo) {
        blogService.blogDetail(inVo);
        return RestResponse.success();
    }


    @PostMapping("/blog/recommend")
    public RestResponse blogRecommend(@RequestBody(required = true) @Validated BlogRecommendInVo inVo) {
        return RestResponse.success(blogService.blogRecommend(inVo));
    }


    @PostMapping("/comment/list")
    public RestResponse commentList(@RequestBody(required = true) @Validated CommentListInVo inVo) {
        return RestResponse.success(blogService.commentList(inVo));
    }


    @PostMapping("/comment/create")
    public RestResponse commentCreate(@RequestBody(required = true) @Validated CommentCreateInVo inVo) {
        blogService.commentCreate(inVo);
        return RestResponse.success();
    }


    @PostMapping("/comment/delete")
    public RestResponse commentDelete(@RequestBody(required = true) @Validated CommentDeleteInVo inVo) {
        blogService.commentDelete(inVo);
        return RestResponse.success();
    }


}
