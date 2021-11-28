package inori.blog.controller;

import inori.blog.annotion.AccessLog;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.IIndexService;
import inori.blog.transfer.index.IndexListInVo;
import inori.blog.transfer.index.IndexRecommendListInVo;
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
public class IndexController {
    @Autowired
    private IIndexService indexService;


    @AccessLog("主页列表")
    @PostMapping("/index/list")
    public RestResponse indexList(@RequestBody(required = true) @Validated IndexListInVo inVo) {
        return RestResponse.success(indexService.indexList(inVo));
    }


    @PostMapping("/index/recommend/list")
    public RestResponse indexRecommendList(@RequestBody(required = true) @Validated IndexRecommendListInVo inVo) {
        return RestResponse.success(indexService.indexRecommendList(inVo));
    }


}
