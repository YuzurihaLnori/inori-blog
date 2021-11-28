package inori.blog.controller;

import inori.blog.common.response.RestResponse;
import inori.blog.serivce.ITypeService;
import inori.blog.transfer.type.TypeListInVo;
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
public class TypeController {
    @Autowired
    private ITypeService typeService;


    @PostMapping("/type/list")
    public RestResponse typeList(@RequestBody(required = true) @Validated TypeListInVo inVo) {
        return RestResponse.success(typeService.typeList(inVo));
    }


}
