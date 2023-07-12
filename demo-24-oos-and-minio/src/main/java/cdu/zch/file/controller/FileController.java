package cdu.zch.file.controller;

import cdu.zch.file.model.FileInfo;
import cdu.zch.file.service.OssService;
import cdu.zch.file.service.impl.MinioOssServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zch
 * @date 2023/7/12
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    private OssService ossService;

    public void setOssService(MinioOssServiceImpl ossService) {
        this.ossService = ossService;
    }

    @PostMapping("/upload")
    public Map<String, Object> uploadFile(
            @RequestParam("file") MultipartFile file
    ) {
        FileInfo fileInfo = ossService.uploadFile(file);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", fileInfo);
        return result;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteFile(
            @RequestParam String filePath
    ) {
        boolean isDelete = ossService.deleteFile(filePath);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", isDelete);
        return result;
    }
}
