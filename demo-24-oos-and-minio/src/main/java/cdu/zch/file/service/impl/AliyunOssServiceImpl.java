package cdu.zch.file.service.impl;

import cdu.zch.file.model.FileInfo;
import cdu.zch.file.service.OssService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * @author Zch
 * @date 2023/7/12
 **/
@Service
@ConditionalOnProperty(name = "oss.type", havingValue = "aliyun")
public class AliyunOssServiceImpl implements OssService {

    @Value("${oss.aliyun.endpoint}")
    private String endPoint;

    @Value("${oss.aliyun.access-key-id}")
    private String accessKetId;

    @Value("${oss.aliyun.access-key-secret}")
    private String accessKeySecret;

    @Value("${oss.aliyun.bucket-name}")
    private String bucketName;

    private OSS aliyunOssClient;

    @PostConstruct
    public void init() {
        aliyunOssClient = new OSSClientBuilder().build(endPoint, accessKetId, accessKeySecret);
    }

    @Override
    public FileInfo uploadFile(MultipartFile file) {
        // 生成文件名(日期文件夹)
        String suffix = FileUtil.getSuffix(file.getOriginalFilename());
        String uuid = IdUtil.simpleUUID();
        String fileName = DateUtil.format(LocalDateTime.now(), "yyyy/MM/dd") + "/" + uuid + "." + suffix;
        //  try-with-resource 语法糖自动释放流
        try (InputStream inputStream = file.getInputStream()) {

            // 设置上传文件的元信息，例如Content-Type
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            // 创建PutObjectRequest对象，指定Bucket名称、对象名称和输入流
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream, metadata);
            // 上传文件
            aliyunOssClient.putObject(putObjectRequest);
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败");
        }
        // 获取文件访问路径
        String fileUrl = "https://" + bucketName + "." + endPoint + "/" + fileName;
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(fileName);
        fileInfo.setUrl(fileUrl);
        return fileInfo;
    }

    @Override
    public boolean deleteFile(String filePath) {
        Assert.notBlank(filePath, "删除文件路径不能为空");
        String fileHost = "https://" + bucketName + "." + endPoint; // 文件主机域名
        String fileName = filePath.substring(fileHost.length() + 1); // +1 是/占一个字符，截断左闭右开
        aliyunOssClient.deleteObject(bucketName, fileName);
        return true;
    }
}
