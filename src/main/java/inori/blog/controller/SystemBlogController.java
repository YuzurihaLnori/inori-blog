package inori.blog.controller;

import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.ISystemBlogService;
import inori.blog.transfer.systemblog.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Inori
 */
@RestController
@RequestMapping("/api/system")
public class SystemBlogController extends BaseRestController {
    @Autowired
    private ISystemBlogService systemBlogService;


    @PostMapping("/blog/list")
    public RestResponse systemBlogList(@RequestBody(required = true) @Validated SystemBlogListInVo inVo) {
        return RestResponse.success(systemBlogService.systemBlogList(this, inVo));
    }


    @PostMapping("/blog/create")
    public RestResponse systemBlogCreate(@RequestBody(required = true) @Validated SystemBlogCreateInVo inVo) {
        systemBlogService.systemBlogCreate(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/blog/update/get")
    public RestResponse systemBlogUpdateGet(@RequestBody(required = true) @Validated SystemBlogUpdateGetInVo inVo) {
        return RestResponse.success(systemBlogService.systemBlogUpdateGet(this, inVo));
    }


    @PostMapping("/blog/update")
    public RestResponse systemBlogUpdate(@RequestBody(required = true) @Validated SystemBlogUpdateInVo inVo) {
        systemBlogService.systemBlogUpdate(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/blog/delete")
    public RestResponse systemBlogDelete(@RequestBody(required = true) @Validated SystemBlogDeleteInVo inVo) {
        systemBlogService.systemBlogDelete(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/blog/recommend")
    public RestResponse systemBlogRecommend(@RequestBody(required = true) @Validated SystemBlogRecommendInVo inVo) {
        return systemBlogService.systemBlogRecommend(this, inVo);
    }


}
