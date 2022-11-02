package com.liaohui.controller;

/**
 * @auther Mr.Liao
 * @date 2022/11/1 18:42
 */

import com.liaohui.common.Resp;
import com.liaohui.common.State;
import com.liaohui.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 进行文件的上传与下载
 * @author liaohui
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${liaohui.path}")
    private String basePath;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Resp upload(MultipartFile file){//这个参数名字必须和表单数据里的name保持一致 type=file
        //调用方法判断文件大小 这里暂设为20M
        boolean fileSize = checkFileSize(file.getSize(), 20,"M");
        if(!fileSize){
            throw new CustomException("上传文件超过规定范围！");
        }

        //原始文件名
        String originFilename = file.getOriginalFilename();
        String suffix = originFilename.substring(originFilename.lastIndexOf("."));

        //使用UUID重新命名，防止文件名字重复
        String fileName = UUID.randomUUID().toString()+suffix;

        //创建一个目录对象
        File dir = new File(basePath);
        if(!dir.exists()){
            //目录不存在，需要创建
            dir.mkdirs();

        }
        try {
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Resp.success(State.OK);
    }
    /**
     * 判断文件大小
     * @param len 文件长度
     * @param size 限制大小
     * @param unit 限制单位（B,K,M,G）
     * @return true 合规
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        // long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double)len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double)len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double)len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double)len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }


    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            //输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
