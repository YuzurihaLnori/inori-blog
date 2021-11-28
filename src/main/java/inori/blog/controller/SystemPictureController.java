package inori.blog.controller;

import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.ISystemPictureService;
import inori.blog.transfer.systeimpicture.SystemPictureCreateInVo;
import inori.blog.transfer.systeimpicture.SystemPictureDeleteInVo;
import inori.blog.transfer.systeimpicture.SystemPictureListInVo;
import inori.blog.transfer.systeimpicture.SystemPictureUpdateInVo;
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
public class SystemPictureController extends BaseRestController {
    @Autowired
    private ISystemPictureService systemPictureService;


    @PostMapping("/picture/list")
    public RestResponse systemPictureList(@RequestBody(required = true) @Validated SystemPictureListInVo inVo) {
        return RestResponse.success(systemPictureService.systemPictureList(this, inVo));
    }


    @PostMapping("/picture/create")
    public RestResponse systemPictureCreate(@RequestBody(required = true) @Validated SystemPictureCreateInVo inVo) {
        systemPictureService.systemPictureCreate(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/picture/update")
    public RestResponse systemPictureUpdate(@RequestBody(required = true) @Validated SystemPictureUpdateInVo inVo) {
        systemPictureService.systemPictureUpdate(this, inVo);
        return RestResponse.success();
    }


    @PostMapping("/picture/delete")
    public RestResponse systemPictureDelete(@RequestBody(required = true) @Validated SystemPictureDeleteInVo inVo) {
        systemPictureService.systemPictureDelete(this, inVo);
        return RestResponse.success();
    }


}
