package inori.blog.controller;

import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.ISystemTypeService;
import inori.blog.transfer.systemtype.SystemTypeCreateInVo;
import inori.blog.transfer.systemtype.SystemTypeDeleteInVo;
import inori.blog.transfer.systemtype.SystemTypeListInVo;
import inori.blog.transfer.systemtype.SystemTypeUpdateInVo;
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
public class SystemTypeController extends BaseRestController {
    @Autowired
    private ISystemTypeService systemTypeService;


    @PostMapping("/type/list")
    public RestResponse systemTypeList(@RequestBody(required = true) @Validated SystemTypeListInVo inVo) {
        return RestResponse.success(systemTypeService.systemTypeList(this, inVo));
    }


    @PostMapping("/type/create")
    public RestResponse systemTypeCreate(@RequestBody(required = true) @Validated SystemTypeCreateInVo inVo) {
        systemTypeService.systemTypeCreate(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/type/update")
    public RestResponse systemTypeUpdate(@RequestBody(required = true) @Validated SystemTypeUpdateInVo inVo) {
        systemTypeService.systemTypeUpdate(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/type/delete")
    public RestResponse systemTypeDelete(@RequestBody(required = true) @Validated SystemTypeDeleteInVo inVo) {
        systemTypeService.systemTypeDelete(this, inVo);
        return RestResponse.success();
    }


}
