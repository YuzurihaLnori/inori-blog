package inori.blog.serivce;


import inori.blog.common.aliyun.AliyunCloudStorageService;
import inori.blog.common.constants.AliyunConstants;
import inori.blog.model.OssFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author Inori
 */
@Slf4j
@Service
public class OssService {
    @Value("${inori.oss.endpoint}")
    private String endpoint;

    @Value("${inori.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${inori.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${inori.oss.httpBase}")
    private String httpBase;

    @Value("${inori.oss.bucket}")
    private String bucket;


    public OssFile uploadFile(String fileName, InputStream inputStream) throws Exception {
        AliyunConstants aliyunConstants = new AliyunConstants();
        aliyunConstants.setAccessKeyId(accessKeyId);
        aliyunConstants.setAccessKeySecret(accessKeySecret);
        aliyunConstants.setBucket(bucket);
        aliyunConstants.setEndpoint(endpoint);
        aliyunConstants.setHttpBase(httpBase);

        String path = System.currentTimeMillis() + "_" + fileName;
        AliyunCloudStorageService service = new AliyunCloudStorageService();
        service.setAliyunConstants(aliyunConstants);
        service.upload(inputStream, path);

        String url = service.getBaseUrl() + URLEncoder.encode(path, "UTF-8");
        OssFile result = new OssFile();
        result.setPath(path);
        result.setUrl(url);
        return result;
    }


}
