package inori.blog.controller;

import inori.blog.annotion.AccessLog;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.IArchivesService;
import inori.blog.transfer.archives.ArchivesListInVo;
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
public class ArchivesController {
    @Autowired
    private IArchivesService archivesControl;


    @AccessLog("归档列表")
    @PostMapping("/archives/list")
    public RestResponse archivesList(@RequestBody(required = true) @Validated ArchivesListInVo inVo) {
        return RestResponse.success(archivesControl.archivesList(inVo));
    }


}
