package cdu.zch.qiniuyun.utils;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Zch
 * @date 2023/7/17
 **/
@Component
public class ImageUtils {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.domain}")
    private String domain;

    /**
     * 处理多文件
     * @param multipartFiles
     * @return
     */
    public Map<String, List<String>> uploadImages(MultipartFile[] multipartFiles){
        Map<String,List<String>> map = new HashMap<>();
        List<String> imageUrls = new ArrayList<>();
        for(MultipartFile file : multipartFiles){
            imageUrls.add(uploadImageQiniu(file));
        }
        map.put("imageUrl",imageUrls);
        return map;
    }

    /**
     * 上传图片到七牛云
     * @param multipartFile
     * @return
     */
    public String uploadImageQiniu(MultipartFile multipartFile){
        try {
            //1、获取文件上传的流
            byte[] fileBytes = multipartFile.getBytes();
            //2、创建日期目录分隔
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String datePath = dateFormat.format(new Date());

            //3、获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = datePath+"/"+UUID.randomUUID().toString().replace("-", "")+ suffix;

            //4.构造一个带指定 Region 对象的配置类
            //Region.huadongZheJiang2()(根据自己的对象空间的地址选
            Configuration cfg = new Configuration(Region.huadongZheJiang2());
            UploadManager uploadManager = new UploadManager(cfg);

            //5.获取七牛云提供的 token
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            uploadManager.put(fileBytes,filename,upToken);

            return domain + filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
