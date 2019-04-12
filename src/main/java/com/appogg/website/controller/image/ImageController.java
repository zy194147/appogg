package com.appogg.website.controller.image;

import com.appogg.website.auth.UserCheck;
import com.appogg.website.entity.OggUser;
import com.appogg.website.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/image/")
public class ImageController {
    @Autowired
    private UserCheck userCheck;

    @PostMapping("upload")
    public Map<String, Object> imageUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){

//        OggUser loginUser = userCheck.getLoginUser(request);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String uploadDate = sdf.format(date);
//        if (loginUser != null){
//            System.out.println("文件上传。。。。。。" +loginUser.toString());
        System.out.println("文件上传。。。。。。" + "."+uploadDate);
//        }
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//        String filePath = "F:\\appogg\\uploadTitleImage\\" + "upload\\"; // 上传后的路径
        String filePath = "/root/appogg/dist/image/"; // 上传后的路径
        fileName =  uploadDate + UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imageSrc = "http://149.28.144.141/image/" + fileName;
//        String imageSrc = "http://149.28.144.141/image/" + "c776cc8b-7e6d-4b8a-a30b-708d9e48f6ec.jpg";

        System.out.println("filename:" + imageSrc);

        Map<String, Object> map = new HashMap<>(2);
        map.put("errno", 0);
        map.put("data", imageSrc);
        return map;
//        return new ObjectRestResponse().data(imageSrc);
    }
}
