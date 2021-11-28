package inori.blog.controller;

import inori.blog.annotion.AccessLog;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.IPictureService;
import inori.blog.transfer.picture.PictureListInVo;
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
public class PictureController {
    @Autowired
    private IPictureService pictureService;


    @AccessLog("照片墙列表")
    @PostMapping("/picture/list")
    public RestResponse pictureList(@RequestBody(required = true) @Validated PictureListInVo inVo) {
        return RestResponse.success(pictureService.pictureList(inVo));
    }


}
