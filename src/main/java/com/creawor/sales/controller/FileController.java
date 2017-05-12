package com.creawor.sales.controller;

import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Zero on 2017/4/18.
 * 文件上传下载Controller
 */
@RestController
@RequestMapping(value = "file")
public class FileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class.getSimpleName());

    @Value("${sales.files.folder}")
    private String UPLOADED_FOLDER;

    /**
     * 单文件上传
     *
     * @param file 文件
     * @return 响应Json
     */
    @PostMapping(value = "upload")
    @ResponseBody
    public RestResult singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new MultipartException("Please select a file to upload");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RestResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "uploads")
    @ResponseBody
    public RestResult multipleFileUpload(@RequestParam("file") MultipartFile[] files) {
        if (null == files || 0 == files.length) {
            throw new MultipartException("Please select a file to upload");
        }
        try {
            for (MultipartFile file : files) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
                Files.write(path, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RestResultGenerator.genSuccessResult();
    }

    /**
     * 下载文件
     * @param response 响应
     * @param filePath 文件路径
     */
    @GetMapping("download")
    public void downloadFile(HttpServletResponse response,
                                   @RequestParam("filePath") String filePath) {
        try {
            File file = new File(filePath);
//            String[] fp = filePath.split("\\\\");
//            String fileName = fp[fp.length - 1];// 文件名称
            String fileName = file.getName();
            LOGGER.debug("-------------------------------下载文件名为=" + fileName);

            //下载机器码文件
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" +
                    new String(fileName.getBytes("ISO-8859-1"), "UTF-8"));

            OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);

            InputStream is = null;

            is = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(is);

            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];

            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
