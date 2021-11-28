package inori.blog.controller;

import inori.blog.annotion.AccessLog;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.ISearchService;
import inori.blog.transfer.search.SearchListInVo;
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
public class SearchController {
    @Autowired
    private ISearchService searchService;


    @AccessLog("搜索结果")
    @PostMapping("/search/list")
    public RestResponse searchList(@RequestBody(required = true) @Validated SearchListInVo inVo) {
        return RestResponse.success(searchService.searchList(inVo));
    }


}
