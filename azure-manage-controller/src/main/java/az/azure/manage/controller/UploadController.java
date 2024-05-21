package az.azure.manage.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Az
 * @date 2024/5/16
 */
@Slf4j
@Controller
@Api(tags = "上传文件")
public class UploadController {

    @Value("${file.upload.path}")
    private String path;

    @GetMapping("/up")
    public String uploadPage() {
        return "upload";
    }

    @GetMapping("/upBatch")
    public String upBatchloadPage() {
        return "/uploadBatch";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;
        log.info("上传文件名为：{},保存文件路径：{}",fileName,filePath);

        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        return "Upload file success : " + dest.getAbsolutePath();
    }

    @PostMapping("/uploadbatch")
    @ResponseBody
    public String create(@RequestPart MultipartFile[] files) throws IOException {
        StringBuffer message = new StringBuffer();

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String filePath = path + fileName;

            File dest = new File(filePath);
            if(dest.exists()){
                int dot = filePath.indexOf(".");
                dest = new File(filePath.substring(0,dot)+"&"+System.currentTimeMillis()+filePath.substring(dot));
            }
            Files.copy(file.getInputStream(), dest.toPath());
            message.append("Upload file success : " + dest.getAbsolutePath()).append("<br>");
        }
        return message.toString();
    }

}
