package inori.blog.controller;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.model.OssFile;
import inori.blog.model.Res;
import inori.blog.model.Upload;
import inori.blog.serivce.IResService;
import inori.blog.serivce.OssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Inori
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ToolController extends BaseRestController {
    @Autowired
    private IResService resService;

    @Autowired
    private OssService ossService;

    @Value("${inori.oss.endpoint}")
    private String endpoint;

    @Value("${inori.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${inori.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${inori.oss.bucket}")
    private String bucket;


    @PostMapping("/tool/file/upload")
    @ResponseBody
    public RestResponse upload(MultipartFile file, String typeCode) {
        try {
            OssFile ssoFile = ossService.uploadFile(file.getOriginalFilename(), file.getInputStream());
            Res res = new Res();
            res.setPath(ssoFile.getPath());
            res.setTypeCode(typeCode);
            resService.insert(res);
            return RestResponse.success(new Upload(res.getId(), ssoFile.getUrl()));
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(RestResponse.CODE_SERVER_ERROR, e.getCause().toString());
        }
    }

    /**
     * 下载文件
     */
    @PostMapping("/tool/file/download")
    @ResponseBody
    public RestResponse downFile(String pathName, String localName) {
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ossClient.getObject(new GetObjectRequest(bucket, pathName), new File(localName));
            ossClient.shutdown();
            return RestResponse.success(ossClient);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.fail(RestResponse.CODE_SERVER_ERROR, e.getCause().toString());
        }
    }


}
