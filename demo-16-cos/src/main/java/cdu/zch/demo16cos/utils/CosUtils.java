package cdu.zch.demo16cos.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Zch
 * @data 2023/4/26
 **/

@Component
public class CosUtils {

    @Value("${tencent.cloud.appId}")
    private String appId;

    @Value("${tencent.cloud.secretId}")
    private String secretId;

    @Value("${tencent.cloud.secretKey}")
    private String secretKey;

    @Value("${tencent.cloud.region}")
    private String region;

    @Value("${tencent.cloud.bucket}")
    private String bucket;

    private COSClient getCosClient() {
        COSCredentials credentials = new BasicCOSCredentials(secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        clientConfig.setHttpProtocol(HttpProtocol.https);
        COSClient cosClient = new COSClient(credentials, clientConfig);
        return cosClient;
    }

    public HashMap uploadFile(MultipartFile file, TypeEnum type) throws IOException {
        String path = null;
        String fileName = file.getOriginalFilename();
        if (type == TypeEnum.ARCHIVE) {
            path = "/archive/" + IdUtil.simpleUUID() + fileName.substring(fileName.lastIndexOf("."));
        }

        //元数据信息
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(file.getSize());
        meta.setContentEncoding("UTF-8");
        meta.setContentType(file.getContentType());

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket + "-" + appId, path, file.getInputStream(), meta);
        putObjectRequest.setStorageClass(StorageClass.Standard);
        COSClient client = getCosClient();
        PutObjectResult putObjectResult = client.putObject(putObjectRequest);
        client.shutdown();

        HashMap<String, String> map = new HashMap<>();
        String url = StrUtil.format("https://{}-{}.cos.{}.myqcloud.com{}", bucket, appId, region, path);
//        map.put("url", "https://" + bucket + "-" + appId + ".cos." + region + "myqcloud.com" + path);
        map.put("url", url);
        map.put("path", path);
        // https://emos-1315662121.cos.ap-guangzhou.myqcloud.com/archive/c8b6c2df76bf42a195b9dff07dcbcd3d.png

        return map;
    }

    public void deleteFile(String[] pathes) {
        COSClient client = getCosClient();
        for (String path : pathes) {
            client.deleteObject(bucket, path);
        }
        client.shutdown();
    }

}
