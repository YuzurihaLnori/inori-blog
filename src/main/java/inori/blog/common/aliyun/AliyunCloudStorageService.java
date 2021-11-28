package inori.blog.common.aliyun;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import inori.blog.common.constants.AliyunConstants;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 阿里云对象存储OSS
 *
 * @author Inori
 */
public class AliyunCloudStorageService {
    private AliyunConstants aliyunConstants;

    public void setAliyunConstants(AliyunConstants aliyunConstants) {
        this.aliyunConstants = aliyunConstants;
    }

    public void upload(byte[] data, String path) {
        upload(new ByteArrayInputStream(data), path);
    }

    public void upload(InputStream inputStream, String path) {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        OSS ossClient = new OSSClientBuilder().build(aliyunConstants.getEndpoint(), aliyunConstants.getAccessKeyId(), aliyunConstants.getAccessKeySecret());
        try {
            ossClient.putObject(aliyunConstants.getBucket(), "system-img/" + path, inputStream);
        } finally {
            ossClient.shutdown();
        }
    }

    public void upload(File file, String path) throws Exception {
        upload(new FileInputStream(file), path);
    }

    public String getBaseUrl() {
        return aliyunConstants.getHttpBase();
    }
}
