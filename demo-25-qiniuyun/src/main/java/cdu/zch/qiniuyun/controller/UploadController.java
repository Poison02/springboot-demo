package cdu.zch.qiniuyun.controller;

import cdu.zch.qiniuyun.utils.ImageUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author Zch
 * @date 2023/7/17
 **/
@RestController
public class UploadController {

    private final ImageUtils imageUtils;

    public UploadController(ImageUtils imageUtils) {
        this.imageUtils = imageUtils;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile[] file) {
        if (ObjectUtils.isEmpty(file)) {
            return "Error!!!";
        }
        imageUtils.uploadImages(file);
        return "OK!!!";
    }
}
